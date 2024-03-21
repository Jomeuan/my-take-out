package com.example.mytakeout.config;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.mytakeout.mapper.AuthorityMapper;
import com.example.mytakeout.mapper.CategoryDishMapper;
import com.example.mytakeout.mapper.CategoryMapper;
import com.example.mytakeout.mapper.DishMapper;
import com.example.mytakeout.mapper.UserMapper;


@Configuration
public class MybatisConfig {
    @Autowired
    DataSource druiDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, druiDataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(
                environment);
        configuration.addMapper(UserMapper.class);
        configuration.addMapper(AuthorityMapper.class);
        configuration.addMapper(CategoryMapper.class);
        configuration.addMapper(CategoryDishMapper.class);
        configuration.addMapper(DishMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    

}

