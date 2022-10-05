package com.bitcamp.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;

public class MariaDBBoardDao implements BoardDao {

  Connection con;

  // DAO가 사용할 의존 객체 Connection을 생성자의 파라미터로 받는다.
  public MariaDBBoardDao(Connection con) {
    this.con = con;
  }

  @Override
  public int insert(Board board) throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into app_board(title,cont,mno) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

      // 게시글 제목과 내용을 app_board 테이블에 저장한다.
      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setInt(3, board.getWriter().getNo());
      int count = pstmt.executeUpdate();

      //int boardNo = pstmt.getGeneratedKeys();
      // 아까 말한데로 인서트가 한번에 여러개가 이루어지는 경우 그러면 PK가 여러개 존재할 수 있다.
      // 리턴값은 단순 int값이아니라 컬렉션값이다.
      //List<Integer> boardList = pstmt.getGeneratedKeys();
      // 여러개의 컬럼을 묶어서 하나의 PK로 만들수있다. 그러면 Int가 여러개일 수 있다.=> 불가능하다.
      // 리턴하는거 자체를 resultSet으로 하고 pk가 여러개인경우 rs.next()로 한줄 씩 꺼내서 rs.getInt(1)으로 꺼낼수 있다. 

      //System.out.println("MariaDBBoardDao=pstmt.getGeneratedKeys() : " + pstmt.getGeneratedKeys());
      // 게시글을 app_board 테이블에 입력 한 후 자동 증가된 PK 값을 꺼낸다.
      try (ResultSet rs = pstmt.getGeneratedKeys()) {
        rs.next();
        board.setNo(rs.getInt(1));
        //System.out.println("MariaDBBoardDao=rs.getInt(1) : " + rs.getInt(1));
      }
      return count;
    }
  }

  @Override
  public Board findByNo(int no) throws Exception {
    try (
        PreparedStatement pstmt =
            con.prepareStatement("select b.bno, b.title, b.cdt, b.cont, b.vw_cnt, m.mno, m.name "
                + "from app_board b join app_member m on b.mno = m.mno where b.bno=" + no);
        ResultSet rs = pstmt.executeQuery()) {

      if (!rs.next()) {
        return null;
      }

      Board board = new Board();
      board.setNo(rs.getInt("bno"));
      board.setTitle(rs.getString("title"));
      board.setContent(rs.getString("cont"));
      board.setCreatedDate(rs.getDate("cdt"));
      board.setViewCount(rs.getInt("vw_cnt"));

      Member writer = new Member();
      writer.setNo(rs.getInt("mno"));
      writer.setName(rs.getString("name"));

      board.setWriter(writer);

      // 게시글 첨부파일 조회가져오기
      try (
          PreparedStatement pstmt2 = con
              .prepareStatement("select bfno, filepath, bno from app_board_file where bno=" + no);
          ResultSet rs2 = pstmt2.executeQuery()) {

        ArrayList<AttachedFile> attachedFiles = new ArrayList<>();
        while (rs2.next()) {
          AttachedFile file = new AttachedFile();
          file.setNo(rs2.getInt("bfno"));
          file.setFilepath(rs2.getString("filepath"));
          attachedFiles.add(file);
        }
        board.setAttachedFiles(attachedFiles);
      }

      return board;
    }
  }

  @Override
  public int update(Board board) throws Exception {
    try (PreparedStatement pstmt =
        con.prepareStatement("update app_board set title=?, cont=? where bno=?")) {

      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setInt(3, board.getNo());

      return pstmt.executeUpdate();
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement("delete from app_board where bno=?")) {

      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
    }
  }

  @Override
  public List<Board> findAll() throws Exception {
    try (
        PreparedStatement pstmt = con.prepareStatement(
            "select b.bno, b.title, b.cdt, b.vw_cnt, m.mno, m.name " + "from app_board b "
                + "join app_member m on b.mno = m.mno " + "order by b.bno desc;");
        ResultSet rs = pstmt.executeQuery()) {

      /*
        select 
        b.bno,
        b.title,
        b.cdt,
        b.vw_cnt,
        m.mno,
        m.name
        from app_board b
        join app_member m on b.mno = m.mno
      */

      ArrayList<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));

        Member writer = new Member();
        writer.setNo(rs.getInt("mno"));
        writer.setName(rs.getString("name"));

        board.setWriter(writer);

        list.add(board);
      }
      return list;
    }
  }

  @Override
  public int insertFiles(Board board) throws Exception {
    try (PreparedStatement pstmt =
        con.prepareStatement("insert into app_board_file(filepath, bno) values(?, ?)")) {

      // 게시글의 첨부파일을 app_board_file 테이블에 저장한다.
      List<AttachedFile> attachedFiles = board.getAttachedFiles();
      for (AttachedFile attachedFile : attachedFiles) {
        pstmt.setString(1, attachedFile.getFilepath());
        pstmt.setInt(2, board.getNo());
        pstmt.executeUpdate();
      }

      return attachedFiles.size();
    }
  }

  @Override
  public AttachedFile findFileByNo(int fileNo) throws Exception {
    try (
        PreparedStatement pstmt = con.prepareStatement(
            "select bfno, filepath, bno from app_board_file where bfno=" + fileNo);
        ResultSet rs = pstmt.executeQuery()) {

      if (!rs.next()) {
        return null;
      }
      AttachedFile file = new AttachedFile();
      file.setNo(rs.getInt("bfno"));
      file.setFilepath(rs.getString("filepath"));
      file.setBoardNo(rs.getInt("bno"));

      return file;
    }
  }

  @Override
  public int deleteFile(int fileNo) throws Exception {
    try (
        PreparedStatement pstmt = con.prepareStatement("delete from app_board_file where bfno=?")) {

      pstmt.setInt(1, fileNo);
      return pstmt.executeUpdate();
    }
  }

  @Override
  public int deleteFiles(int boardNo) throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement("delete from app_board_file where bno=?")) {

      pstmt.setInt(1, boardNo);
      return pstmt.executeUpdate();
    }
  }
}


