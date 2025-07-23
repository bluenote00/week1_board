package org.example.week1_board.dao.login;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginDao {
        // 로그인
        void loginUser(Map<String, Object> paramMap) throws Exception;
}
