package com.example.mytakeout.entity;


import lombok.AllArgsConstructor;
import lombok.Data;


//一个用户可以有多个权限
@Data
@AllArgsConstructor
public class Authority {
    private Integer id;
    private Integer userId;
    private String authority;

    public static String ROLE_ADMIN = "ROLE_A";
    public static String ROLE_CONSUMER ="ROLE_C";
    /**
     * 实际应当对应店铺的管理员工，他不能修改用户
     */
    public static String ROLE_STORE = "ROLE_S";
}
