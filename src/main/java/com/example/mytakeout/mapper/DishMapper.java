package com.example.mytakeout.mapper;


import java.util.List;

import com.example.mytakeout.entity.Category;
import com.example.mytakeout.entity.Dish;

public interface DishMapper {
    public int addDish(Dish dish)throws Exception;
    public int deleteDishById(Integer id)throws Exception;
    public List<Dish> getDishesById(List<Integer> dishId)throws Exception;
    public int updateDish(Dish dish)throws Exception;
    public List<Dish> getDishesByCateagoryId(Category category)throws Exception;
}
