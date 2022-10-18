package com.bitcamp.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.delete("MemberDao.delete", no);
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


