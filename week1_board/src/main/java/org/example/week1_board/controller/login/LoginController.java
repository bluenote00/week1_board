package org.example.week1_board.controller.login;

import org.example.week1_board.dto.join.JoinDto;
import org.example.week1_board.dto.login.LoginDto;
import org.example.week1_board.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;

    /**
     * 로그인
     */
    @PostMapping("/loginUser")
    @ResponseBody
    public Map<String, Object> loginUser(@RequestBody LoginDto loginDto) throws Exception {
        logger.info("   - Login start");
        logger.info("   - loginDto : " + loginDto.getLogin_id());
        logger.info("   - loginDto : " + loginDto.getPassword());

        return loginService.loginUser(loginDto);
    }

}
