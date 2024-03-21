package com.example.mytakeout.mapper;

import com.example.mytakeout.entity.User;

public interface UserMapper {
    public User getUserByName(String username);
    public void addUser(User user);
}
