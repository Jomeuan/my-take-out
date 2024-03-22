package com.example.mytakeout.entity;

import java.sql.Timestamp;

import lombok.Data;

/**
 * CREATE TABLE IF NOT EXISTS t_fk_order_dish(
 * id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 * gmt_create DATETIME,
 * gmt_modified DATETIME,
 * dish_id INT UNSIGNED NOT NULL,
 * order_id INT UNSIGNED NOT NULL,
 * dish_quantity INT UNSIGNED NOT NULL COMMENT "菜品数量"
 * );
 */
@Data
public class OrderDishes {
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    // 对应菜肴的外键
    private Integer dishId;
    private Integer quantity;
    // 对应订单的外键
    private Integer orderId;
}
