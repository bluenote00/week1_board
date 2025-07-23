package org.example.week1_board.service.login;

import org.example.week1_board.dao.login.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {

        @Autowired
        private LoginDao loginDao;

        /**
         * 로그인
         */
        public void loginUser(Map<String, Object> paramMap) throws Exception {
            loginDao.loginUser(paramMap);
        }
}
