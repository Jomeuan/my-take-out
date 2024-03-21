package com.example.mytakeout.mapper;

import java.util.List;

import com.example.mytakeout.entity.CategoryDish;

public interface CategoryDishMapper {
    public List<Integer> getDishIdByCategoryId(Integer id)throws Exception;
    public boolean addCategoryDish(CategoryDish categoryDish)throws Exception;
}
