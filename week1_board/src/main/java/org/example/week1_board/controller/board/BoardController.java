package org.example.week1_board.controller.board;

import org.example.week1_board.dto.board.BoardDto;
import org.example.week1_board.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private BoardService boardService;

    // 게시판 조회
    @RequestMapping("/boardList")
    @ResponseBody
    public Map<String, Object> boardList(@RequestParam Map<String, Object> paramMap) throws Exception {
        logger.info("   - Board start");
        logger.info("   - paramMap : " + paramMap);

        int currentPage = Integer.parseInt((String) paramMap.get("currentpage"));
        int pageSize = Integer.parseInt((String) paramMap.get("pagesize"));
        int pageIndex = (currentPage - 1) * pageSize;

        paramMap.put("pageIndex", pageIndex);
        paramMap.put("pageSize", pageSize);

        List<BoardDto> boardList = boardService.boardList(paramMap);
        int boardCnt = boardService.boardCnt(paramMap);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("boardList", boardList);
        resultMap.put("totalcnt", boardCnt);

        logger.info("   - Board List");
        logger.info("   - resultMap : " + resultMap);

        return resultMap;
    }

    @PostMapping("/insertBoard")
    @ResponseBody
    public Map<String, Object> insertBoard(HttpSession session, @RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        logger.info("insertBoard start");
        logger.info("   - paramMap : " + paramMap);

        Map<String, Object> returnmap = new HashMap<String,Object>();
        try {
            boardService.insertBoard(paramMap);

            returnmap.put("resultmsg","등록 되었습니다.");

        } catch (Exception e) {
            throw e;
        }

        return returnmap;
    }

    @PostMapping("/updateBoard")
    @ResponseBody
    public Map<String, Object> updateBoard(HttpSession session,@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        logger.info("updateBoard start");
        logger.info("   - paramMap : " + paramMap);

        paramMap.put("board_no", paramMap.get("board_no"));

        Map<String, Object> returnmap = new HashMap<String,Object>();

        try {
            boardService.updateBoard(paramMap);

            returnmap.put("resultmsg","수정 되었습니다.");
        } catch (Exception e) {
            throw e;
        }

        return returnmap;
    }

    @PostMapping("/deleteBoard")
    @ResponseBody
    public Map<String, Object> deleteBoard(@RequestBody Map<String, Object> paramMap) throws Exception {
        logger.info("deleteBoard start");
        logger.info("      paramMap : " + paramMap);

        Map<String, Object> returnmap = new HashMap<>();

        try {
            boardService.deleteBoard(paramMap);
            returnmap.put("resultmsg", "삭제 되었습니다.");
        } catch (Exception e) {
            returnmap.put("resultmsg", e.getMessage());
        }

        return returnmap;
    }
}
