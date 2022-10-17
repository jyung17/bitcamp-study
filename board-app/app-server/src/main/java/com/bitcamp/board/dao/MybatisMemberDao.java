package com.bitcamp.board.dao;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bitcamp.board.domain.Member;

// Spring IoC 컨테이너가 관리하는 개체임을 표시한다.
@Repository // DAO 역할을 수행하는 객체에 붙이는 애노테이션
// - 이 애노테이션을 붙이면 Spring IoC 컨테이너가 객체를 자동 생성한다.
// - 객체의 이름을 명시하지 않으면
//   클래스 이름(첫 알파벳은 소문자. 예: "mybatisMemberDao")을 사용하여 저장한다.
// - 물론 생성자의 파라미터 값을 자동으로 주입한다.
// - 파라미터에 해당하는 객체가 없다면 생성 오류가 발생한다.
public class MybatisMemberDao implements MemberDao {

  @Autowired
  DataSource ds;
  @Autowired
  SqlSessionFactory sqlSessionFactory;

  @Override
  public int insert(Member member) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.insert("MemberDao.insert", member);
    }
  }

  @Override
  public Member findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.selectOne("MemberDao.findByNo", no);
    }
  }

  @Override
  public int update(Member member) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.update("MemberDao.update", member);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (
        PreparedStatement pstmt1 =
            ds.getConnection().prepareStatement("delete from app_board where mno=?");
        PreparedStatement pstmt2 =
            ds.getConnection().prepareStatement("delete from app_member where mno=?")) {

      // 커넥션 객체를 수동 커밋 상태로 설정한다.
      ds.getConnection().setAutoCommit(false);

      // 회원이 작성한 게시글을 삭제한다.
      pstmt1.setInt(1, no);
      pstmt1.executeUpdate();

      // 회원을 삭제한다.
      pstmt2.setInt(1, no);
      int count = pstmt2.executeUpdate();

      // 현재까지 작업한 데이터 변경 결과를 실제 테이블에 적용해 달라고 요청한다.
      ds.getConnection().commit();

      return count;

    } catch (Exception e) {
      // 예외가 발생하면 마지막 커밋 상태로 돌린다.
      // => 임시 데이터베이스에 보관된 이전 작업 결과를 모두 취소한다.
      ds.getConnection().rollback();

      // 예외 발생 사실을 호출자에게 전달한다.
      throw e;

    } finally {
      // 삭제 작업 후 자동 커밋 상태로 전환한다.
      ds.getConnection().setAutoCommit(true);
    }
  }

  @Override
  public List<Member> findAll() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.selectList("MemberDao.findAll");
    }
  }

  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {

      Map<String, Object> paramMap = new HashMap<>();
      paramMap.put("email", email);
      paramMap.put("password", password);
      return sqlSession.selectOne("MemberDao.findByEmailPassword", // SQL 문의 ID
          paramMap // SQL 문의 in-parameter(#{})에 들어 갈 값을 담고 있는 객체
      );
    }
  }
}


