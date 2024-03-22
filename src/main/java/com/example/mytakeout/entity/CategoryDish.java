package com.example.mytakeout.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CREATE TABLE IF NOT EXISTS t_fk_category_dish(
 * id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 * gmt_create DATETIME,
 * gmt_modified DATETIME,
 * category_id INT UNSIGNED NOT NULL,
 * dish_id INT UNSIGNED NOT NULL
 * );
 */
@AllArgsConstructor
@Data
public class CategoryDish {
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Integer categoryId;
    private Integer dishId;
}
