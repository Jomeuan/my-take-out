package com.example.mytakeout.entity;

public interface Entity<T> {
    /**
     * 判断实体的每个属性是否时合法的，符合数据库的边界要求的
     */
    public boolean isLegalData(T data);
}
