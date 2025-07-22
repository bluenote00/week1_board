package service.join;

import dao.join.JoinDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class JoinService {

    @Autowired
    private JoinDao joinDao;
    /**
     * 회원가입
     */
    public int registerUser(Map<String, Object> paramMap) throws Exception {
        return joinDao.insertUser(paramMap);
    }
}
