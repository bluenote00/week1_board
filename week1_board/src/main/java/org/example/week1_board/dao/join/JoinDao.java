package org.example.week1_board.dao.join;
import org.apache.ibatis.annotations.Mapper;
import java.util.Map;

@Mapper
public interface JoinDao {
    void registerUser(Map<String, Object> paramMap) throws Exception;
}
