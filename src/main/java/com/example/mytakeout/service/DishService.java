package com.example.mytakeout.service;

import java.util.List;

import com.example.mytakeout.entity.Category;
import com.example.mytakeout.entity.Dish;

public interface DishService {
    public Dish getDishById(Integer id)throws Exception;
    public List<Dish> getDishesByCategoryId(Integer categoryId)throws Exception;
    public Dish addDish(Category category,Dish dish)throws Exception;
    public Integer updateDish(Dish dish)throws Exception;
    /**
     * 
     * @param dish 必须带有要删除菜品的id
     * @return
     * @throws Exception
     */
    public Integer deleteDish(Dish dish)throws Exception;
}   
