package com.example.mytakeout.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mytakeout.entity.Order;
import com.example.mytakeout.entity.User;

public interface UserMapper {
    public List<User> get(@Param("columnName") String colName, @Param("value") String value) throws Exception;
    public User getUserByName(String username)throws Exception;
    public int addUser(User user)throws Exception;
    public int updateUser(User user)throws Exception;
    public int deleteUser(User user) throws Exception;
}
