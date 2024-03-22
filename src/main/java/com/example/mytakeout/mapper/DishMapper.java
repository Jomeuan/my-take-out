package com.example.mytakeout.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mytakeout.entity.Category;
import com.example.mytakeout.entity.Dish;

public interface DishMapper {
    public int addDish(Dish dish) throws Exception;

    public int deleteDish(Integer id) throws Exception;

    public int updateDish(Dish dish) throws Exception;
    /**
     * 通过dish的id查找dish
     * @param dishId 用List<Dish> 才能达到形式上的统一，但是这样会降低性能
     * @return
     * @throws Exception
     */
    public List<Dish> getDishesById(List<Integer> dishId) throws Exception;
    /**
     * 通过菜单的id查找菜品
     * @param category
     * @return
     * @throws Exception
     */
    public List<Dish> getDishesByCateagory(Category category) throws Exception;

    public List<Category> get(@Param("columnName") String colName, @Param("value") String value) throws Exception;
}
