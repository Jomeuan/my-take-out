package com.example.mytakeout.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mytakeout.entity.Order;
import com.example.mytakeout.entity.OrderDish;

public interface OrderMapper {
    public List<Order> get(@Param("columnName") String colName, @Param("value") String value) throws Exception;
    public List<OrderDish> getOrderDish(Order order)throws Exception;
    
    /**
     * 只是添加order表里的数据，没有添加外键
     */
    public int addOrder(Order order)throws Exception;;

    public int addOrderDish(Order order,List<OrderDish> orderDishes)throws Exception;

    //订单应当不能修改
    // public int updateDish(Order order,Dish dish,int quantity);

    public int deleteOrder(Order order) throws Exception;

    
}
