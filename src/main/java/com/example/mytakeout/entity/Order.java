package com.example.mytakeout.entity;

import java.sql.Timestamp;

import lombok.Data;

/**
 * CREATE TABLE IF NOT EXISTS t_order(
 * id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 * gmt_create DATETIME,
 * gmt_modified DATETIME,
 * order_state TINYINT,
 * remark VARCHAR(100) COMMENT "订单的备注"
 * );
 */
@Data
public class Order {
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String orderState;
    private String remark;
}
