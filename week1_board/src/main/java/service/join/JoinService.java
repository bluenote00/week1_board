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
    public void resisterUser(Map<String, Object> paramMap) throws Exception {
        joinDao.resisterUser(paramMap);
    }
}
