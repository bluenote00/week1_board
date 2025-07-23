package org.example.week1_board.service.join;

import org.example.week1_board.dao.join.JoinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JoinService {

    @Autowired
    private JoinDao joinDao;
    /** 회원가입 */
    public void registerUser(Map<String, Object> paramMap) throws Exception {
        joinDao.registerUser(paramMap);
    }

    /** 아이디 중복 체크 */
//    public void checkLoginId(Map<String, Object> paramMap) throws Exception {
//        joinDao.checkLoginId(paramMap);
//    }
}
