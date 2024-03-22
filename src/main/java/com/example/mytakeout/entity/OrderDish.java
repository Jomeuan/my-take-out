package com.example.mytakeout.entity;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

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
/**
 * 描述订单里 菜品的信息
 */
@Data
@NoArgsConstructor
public class OrderDish {
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    // 对应订单的外键
    private Integer orderId;
    // 对应菜肴的外键
    private Integer dishId;
    private Integer dishQuantity;
    
}
