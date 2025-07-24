package org.example.week1_board.dao.board;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.week1_board.dto.board.BoardDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardDao {
    // 게시글 리스트
    public List<BoardDto> boardList(Map<String, Object> paramMap);

    // 글 목록 카운트
    public int boardCnt(Map<String, Object> paramMap);

    // 글 생성
    public void insertBoard(Map<String, Object> paramMap) throws Exception;

    // 글 수정
    public void updateBoard(Map<String, Object> paramMap) throws Exception;

    // 글 삭제
    public void deleteBoard(@Param("boardNos") List<Integer> boardNos) throws Exception;
}
