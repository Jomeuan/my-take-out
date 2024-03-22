package com.example.mytakeout.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CREATE TABLE IF NOT EXISTS t_dish (
 * id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 * gmt_create DATETIME,
 * gmt_modified DATETIME,
 * dish_name VARCHAR(30) NOT NULL,
 * introduction VARCHAR(100),
 * price DECIMAL(10, 4),
 * image_path VARCHAR(30)
 * );
 */

@Data
@AllArgsConstructor
/**
 * 菜品
 */
public class Dish {
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String dishName;
    private String introduction;
    private String imagePath;
    private Double price;
}
