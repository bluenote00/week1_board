package org.example.week1_board.service.login;

import org.example.week1_board.dao.login.LoginDao;
import org.example.week1_board.dto.login.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

        @Autowired
        private LoginDao loginDao;

        /**
         * 로그인
         */
        public Map<String, Object> loginUser(LoginDto loginDto) throws Exception {
                String loginId = loginDto.getLogin_id();
                String password = loginDto.getPassword();

                Map<String, Object> resultMap = new HashMap<>();

                // 아이디로 사용자 조회
                Map<String, Object> user = loginDao.selectUserByLoginId(loginId);

                if (user == null) {
                        resultMap.put("status", "null");
                        resultMap.put("message", "존재하지 않는 회원입니다.");
                } else {
                        String dbPassword = (String) user.get("password");

                        if (password.equals(dbPassword)) {
                                resultMap.put("status", "success");
                                resultMap.put("message", "로그인되었습니다.");
                        } else {
                                resultMap.put("status", "fail");
                                resultMap.put("message", "잘못된 비밀번호입니다.");
                        }
                }

                return resultMap;
        }
}
