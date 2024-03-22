package com.example.mytakeout.entity;

import java.sql.Timestamp;

import lombok.Data;

/**
 * CREATE TABLE IF NOT EXISTS t_shopping_cart(
 * id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 * gmt_create DATETIME,
 * gmt_modified DATETIME,
 * dish_id INT UNSIGNED NOT NULL,
 * dish_quantity INT UNSIGNED NOT NULL COMMENT "菜品数量"
 * );
 */
@Data
public class ShoppingCart {
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Integer dishId;
    private Integer quantity;
}
