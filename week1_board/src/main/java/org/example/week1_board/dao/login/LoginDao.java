package org.example.week1_board.dao.login;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginDao {
        // 계정 확인
        Map<String, Object> selectUserByLoginId(String loginId);

}
