package com.example.mytakeout.entity;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CREATE TABLE IF NOT EXISTS t_category (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    gmt_create DATETIME,
    gmt_modified DATETIME,
    category_name CHAR(30),
    introduction VARCHAR(100),
    category_sort INT
);
 */

/**
 * 菜单，一级目录，目录下是他对应的菜品
 */
@Data
@NoArgsConstructor
public class Category implements Entity<Category> {
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String categoryName;
    private String introduction;
    private Integer categorySort;

    @Override
    public boolean isLegalData(Category data) {
        return id>0 && categoryName.length()<30;
    }


}
// TODO: 将数据库信息插入此处，供mapper层，service层使用，
// 好像只能手写注入，因为没有连接sql语句的办法

//TODO : 约束接口，工厂函数