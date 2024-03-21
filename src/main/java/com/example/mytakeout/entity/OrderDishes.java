package com.example.mytakeout.entity;

import lombok.Data;

@Data
public class OrderDishes {
    //对应菜肴的外键
    private Integer dishId;
    private Integer quantity;
    //对应订单的外键
    private Integer orderId;
}
