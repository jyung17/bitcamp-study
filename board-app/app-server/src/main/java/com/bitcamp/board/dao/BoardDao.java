package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;

public interface BoardDao {
  int insert(Board board) throws Exception; // < - Method signature

  Board findByNo1(int no) throws Exception;

  Board findByNo2(int no) throws Exception;

  Board findByNo3(int no) throws Exception;

  int update(Board board) throws Exception;

  int delete(int no) throws Exception;

  int deleteByMember(int memberNo) throws Exception; // 회원번호로 그 회원이 작성한 게시글 삭제

  int insertFiles(Board board) throws Exception;

  List<Board> findAll() throws Exception;

  AttachedFile findFileByNo(int fileNo) throws Exception;

  List<AttachedFile> findFilesByBoard(int boardNo) throws Exception;

  int deleteFile(int fileNo) throws Exception;

  int deleteFiles(int boardNo) throws Exception;

  int deleteFilesByMemberBoards(int memberNo) throws Exception; // 회원번호로 그 회원이 작성한 게시글들의 모든 첨부파일을 삭제
}


