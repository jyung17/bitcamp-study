package com.bitcamp.board.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;

@Mapper // DAO를 자동생성할때 사용하는 Mapper 클래스다
public interface BoardDao {
  int insert(Board board);// < - Method signature

  Board findByNo(int no);

  int update(Board board);

  int delete(int no);

  int deleteByMember(int memberNo);// 회원번호로 그 회원이 작성한 게시글 삭제

  int insertFiles(Board board);

  List<Board> findAll();

  AttachedFile findFileByNo(int fileNo);

  List<AttachedFile> findFilesByBoard(int boardNo);

  int deleteFile(int fileNo);

  int deleteFiles(int boardNo);

  int deleteFilesByMemberBoards(int memberNo);// 회원번호로 그 회원이 작성한 게시글들의 모든 첨부파일을 삭제
}


