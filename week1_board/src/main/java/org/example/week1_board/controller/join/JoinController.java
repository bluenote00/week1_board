package org.example.week1_board.controller.join;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.example.week1_board.service.join.JoinService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/join")
public class JoinController {

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private JoinService joinService;

    /**
     * 회원가입
     */
    @PostMapping("/register")
    @ResponseBody
    public Map<String, Object> registerUser(@RequestBody Map<String, Object> paramMap) throws Exception {
        logger.info("   - Join start");
        logger.info("   - paramMap : " + paramMap);

        Map<String, Object> returnmap = new HashMap<String, Object>();

        String login_id = (String) paramMap.get("login_id");

        // 중복 아이디 검사
        Map<String, Object> checkMap = new HashMap<>();
        checkMap.put("login_id", login_id);

        int duplicateCount = joinService.checkLoginId(checkMap);

        if (duplicateCount > 0) {
            returnmap.put("message", "1");

        } else {
            try {
                joinService.registerUser(paramMap);
                returnmap.put("message", "2");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return returnmap;
    }

}