package org.example.week1_board.controller.join;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.example.week1_board.service.join.JoinService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/join")
public class JoinController {
    @Autowired
    private JoinService joinService;

    /**
     * 회원가입
     */
    @PostMapping("/register")
    @ResponseBody
    public Map<String, Object> registerUser(@RequestBody Map<String, Object> paramMap) throws Exception {

        Map<String, Object> returnmap = new HashMap<String,Object>();

        try {
            joinService.registerUser(paramMap);
            returnmap.put("resultmsg","가입 되었습니다.");

        } catch (Exception e) {
            throw e;
        }
        return returnmap;
    }


}
