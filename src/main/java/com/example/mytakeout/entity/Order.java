package com.example.mytakeout.entity;

import lombok.Data;

@Data
public class Order {
    // @TableId
    private Integer id;
    private String mode;
    private String remark;
}
