package org.example.week1_board.dao.join;
import org.apache.ibatis.annotations.Mapper;
import java.util.Map;

@Mapper
public interface JoinDao {
    // 회원가입
    void registerUser(Map<String, Object> paramMap) throws Exception;

    // 아이디 중복 체크
    int checkLoginId(Map<String, Object> paramMap) throws Exception;
}
