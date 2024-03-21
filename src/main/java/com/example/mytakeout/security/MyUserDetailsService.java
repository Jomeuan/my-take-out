package com.example.mytakeout.security;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.mytakeout.entity.Authority;
import com.example.mytakeout.mapper.AuthorityMapper;
import com.example.mytakeout.mapper.UserMapper;

import jakarta.annotation.PostConstruct;

import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    // @Autowired
    // public void  setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
    //     this.sqlSessionFactory= sqlSessionFactory;
    // }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            AuthorityMapper authorityMapper = session
                    .getMapper(AuthorityMapper.class);
            com.example.mytakeout.entity.User user = userMapper
                    .getUserByName(username);
            if (user == null) {
                System.out.println("user not exists");
                throw new UsernameNotFoundException("user not exists");
            } else {
                List<String> authorities = authorityMapper.getAuthorityByUserId(user.getId());
                User result = new User(
                        user.getUserName(),
                        user.getSecretCode(),
                        AuthorityUtils.createAuthorityList(authorities));
                return result;
            }
        }
    }
    @PostConstruct
    private void createRootUser() {
        // 打不开 session
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            com.example.mytakeout.entity.User user = userMapper.getUserByName("root");
            // 如果不存在“root"用户就创建
            if (user == null) {
                com.example.mytakeout.entity.User rootUser = new com.example.mytakeout.entity.User(null, "root",
                        passwordEncoder.encode("root"), true);
                userMapper.addUser(rootUser);
                session.commit();
                System.out.println("!!!create root ");
                user = rootUser;
            }
            // 判断是否配置了权限
            AuthorityMapper authorityMapper = session.getMapper(AuthorityMapper.class);
            if (user != null &&
                    !authorityMapper
                            .getAuthorityByUserId(user.getId())
                            .contains(Authority.ROLE_ADMIN)) {
                Authority rootAuthority = new Authority(null, user.getId(), Authority.ROLE_ADMIN);
                authorityMapper.addAuthority(rootAuthority);
                session.commit();
                System.out.println("!!!" + "crete root authority");
            }
        } catch (Exception e) {
            System.out.println("!!!" + e);
        }
    }
}
