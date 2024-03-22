package com.example.mytakeout.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CREATE TABLE IF NOT EXISTS t_authority(
 * id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 * gmt_create DATETIME,
 * gmt_modified DATETIME,
 * user_id INT UNSIGNED NOT NULL,
 * authority CHAR(16) NOT NULL COMMENT "A-admin C-consumer S-Store"
 * );
 */
// 一个用户可以有多个权限
@Data
@AllArgsConstructor
public class Authority implements Entity<Authority> {
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Integer userId;
    private String authority;

    public static String ROLE_ADMIN = "ROLE_A";
    public static String ROLE_CONSUMER = "ROLE_C";
    /**
     * 实际应当对应店铺的管理员工，他不能修改用户
     */
    public static String ROLE_STORE = "ROLE_S";

    @Override
    public boolean isLegalData(Authority data) {
        return userId != null && authority != null;
    }
}
