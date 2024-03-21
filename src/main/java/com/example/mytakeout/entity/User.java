package com.example.mytakeout.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String secretCode;
    private Boolean valid;
}
