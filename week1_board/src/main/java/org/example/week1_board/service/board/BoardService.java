package org.example.week1_board.service.board;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.week1_board.dao.board.BoardDao;
import org.example.week1_board.dto.board.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private BoardDao boardDao;

    // 게시글 리스트
    public List<BoardDto> boardList(Map<String, Object> paramMap) throws Exception {
        return boardDao.boardList(paramMap);
    }
    
    // 페이징
    public int boardCnt(Map<String, Object> paramMap) throws Exception {
        return boardDao.boardCnt(paramMap);
    }

    // 게시글 등록
    public void insertBoard(Map<String, Object> paramMap) throws Exception {
        boardDao.insertBoard(paramMap);
    }

    // 게시글 수정
    public void updateBoard(Map<String, Object> paramMap) throws Exception {
        boardDao.updateBoard(paramMap);
    }

    // 게시글 삭제
    public void deleteBoard(Map<String, Object> paramMap) throws Exception {
        List<Integer> boardNos = (List<Integer>) paramMap.get("board_no");
        boardDao.deleteBoard(boardNos);
    }
}
