package com.example.mytakeout.entity;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
public class Order implements Entity<Order> {
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Integer orderState;
    private String remark;

    @Override
    public boolean isLegalData(Order data) {
        return id > 0 && orderState>=-128 && orderState<=127;
    }
}
