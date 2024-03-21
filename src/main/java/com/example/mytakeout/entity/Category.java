package com.example.mytakeout.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
/*
| Field      | Type         | Null | Key | Default | Extra          |

| id         | int          | NO   | PRI | NULL    | auto_increment |
| dish_name  | varchar(30)  | YES  | UNI | NULL    |                |
| detail     | varchar(100) | YES  |     | NULL    |                |
| image_path | varchar(30)  | YES  |     | NULL    |                |
| price      | float(7,3)   | YES  |     | NULL    |                |
 */
/*
 * 菜单，是一级目录
 */
@Data
@AllArgsConstructor
public class Category {
    // @TableId
    private Integer id;
    private String categoryName;
    private String detail;

}
