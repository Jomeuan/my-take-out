package com.example.mytakeout.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * CREATE TABLE IF NOT EXISTS t_user(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    gmt_create DATETIME,
    gmt_modified DATETIME,
    user_name char(10) UNIQUE NOT NULL,
    user_password varchar(500) NOT NULL,
    user_state TINYINT NOT NULL
);
 */
@Data 
@AllArgsConstructor
public class User {
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String userName;
    private String userPassword;
    //TODO : 描述用户的状态
    private Boolean userState;
}
