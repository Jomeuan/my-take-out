package com.example.mytakeout.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

// | Field       | Type | Null | Key | Default | Extra          |

// | id          | int  | NO   | PRI | NULL    | auto_increment |
// | category_id | int  | YES  | MUL | NULL    |                |
// | dish_id     | int  | YES  | MUL | NULL    |                |
@AllArgsConstructor
@Data
public class CategoryDish {
    private Integer id;
    private Integer categoryId;
    private Integer dishId;
}
