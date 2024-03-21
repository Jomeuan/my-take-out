package com.example.mytakeout.entity;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
/**
 * 菜品
 */
public class Dish {
    // @TableId(type = IdType.AUTO)
    private Integer id;
    private String dishName;
    private String detail;
    private String imagePath;
    private Double price;
}
