package com.example.mytakeout.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mytakeout.entity.User;
import com.example.mytakeout.mapper.UserMapper;

@Service
public class UserServiceImpl {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Autowired
    PasswordEncoder passwordEncoder;
    public void creatRootUser() throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            // 如果不存在“root"用户就创建
            if (userMapper.getUserByName("root") == null) {
                User user = new User(null, "root", passwordEncoder.encode("root"), true);
                userMapper.addUser(user);
            }
        }
    }
}
