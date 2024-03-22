package com.example.mytakeout.entity;

public interface Entity<T> {
    /**
     * 判断实体的每个属性是否时合法的，符合数据库的边界要求的
     * 不需要实现外键约束合法判断，主键约束交给数据库
     */
    public boolean isLegalData(T data);
}
