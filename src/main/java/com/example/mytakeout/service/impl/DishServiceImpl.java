package com.example.mytakeout.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mytakeout.entity.Category;
import com.example.mytakeout.entity.CategoryDish;
import com.example.mytakeout.entity.Dish;
import com.example.mytakeout.mapper.CategoryDishMapper;
import com.example.mytakeout.mapper.DishMapper;
import com.example.mytakeout.service.DishService;
import com.example.mytakeout.utils.ExceptionUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DishServiceImpl implements DishService {
    @Autowired
    SqlSessionFactory sessionFactory;

    

    @Override
    public Dish getDishById(Integer id) throws Exception {
        try (SqlSession session = sessionFactory.openSession()) {
            DishMapper dishMapper = session.getMapper(DishMapper.class);
            List<Integer> singleIdList = Arrays.asList(id);
            List<Dish> result = dishMapper.getDishesById(singleIdList);
            if (result.size() == 0)
                throw new RuntimeException("不存在此菜单");
            else if (result.size() == 1)
                return result.get(0);
            else {
                throw new RuntimeException(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }
        }
        // 可能的异常：不存在该id
        catch (Exception e) {
            String msg = e.getMessage();
            //
            if (msg.equals("不存在此菜单"))
                throw new RuntimeException(msg);
            else {
                log.error(msg, e);
                throw new RuntimeException(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }
        }
    }

    /**
     * 
     */
    @Override
    public List<Dish> getDishesByCategoryId(Integer categoryId) throws Exception {
        Category category = new Category(categoryId, null, null);
        try (SqlSession session = sessionFactory.openSession()) {
            DishMapper dishMapper = session.getMapper(DishMapper.class);
            return dishMapper.getDishesByCateagoryId(category);
        }
        // 可能的错误：categoryId不存在？
        catch (RuntimeException e) {
            String msg = e.getMessage();
            log.error(msg + category);
            throw new RuntimeException(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
        }
    }

    @Override
    public Dish addDish(Category category, Dish dish) throws Exception {
        try (SqlSession session = sessionFactory.openSession()) {
            DishMapper dishMapper = session.getMapper(DishMapper.class);
            int r = dishMapper.addDish(dish);
            if (r == 0){
                throw new Exception(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }
            else {
                CategoryDishMapper categoryDishMapper = session.getMapper(CategoryDishMapper.class);
                categoryDishMapper.addCategoryDish(new CategoryDish(null, category.getId(), dish.getId()));
                session.commit();
                return dish;
            }
        }
        // 可能存在的异常：dishName 重复，数据格式不对（太长了、溢出了）
        catch (Exception e) {
            String msg = e.getMessage();
            // dishName 重复
            if (msg.contains("Duplicate"))
                throw new Exception("菜品名字重复");
            // TODO:数据格式不对（太长了、溢出了）
            else {
                log.error(msg, e);
                throw new Exception(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }
        }
    }

    @Override
    public Integer updateDish(Dish dish) throws Exception{
        try (SqlSession session = sessionFactory.openSession()) {
            DishMapper dishMapper = session.getMapper(DishMapper.class);
            Integer r = dishMapper.updateDish(dish);
            session.commit();
            if (r == 0)
                throw new Exception("不存在此菜品");
            else
                return r;
        }
        // 可能的异常： 不存在此dish
        catch (Exception e) {
            String msg = e.getMessage();
            // 不存在此dish
            if (msg.equals("不存在此菜品"))
                throw e;
            else {
                log.error(msg, e);
                throw new Exception(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }
        }
    }

    @Override
    public Integer deleteDish(Dish dish)throws Exception{
        try (SqlSession session = sessionFactory.openSession()) {
            DishMapper dishMapper = session.getMapper(DishMapper.class);
            Integer r = dishMapper.deleteDishById(dish.getId());
            session.commit();
            if (r == 0)
                throw new Exception("删除失败");
            else
                return r;
        }
        // 可能的异常： 不存在此dish
        catch (Exception e) {
            String msg = e.getMessage();
            // 不存在此dish
            if (msg.equals("删除失败"))
                throw e;
            else {
                log.error(msg, e);
                throw new Exception(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }
        }
    }

}
