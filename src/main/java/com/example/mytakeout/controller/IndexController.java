package com.example.mytakeout.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mytakeout.entity.Category;
import com.example.mytakeout.entity.Dish;
import com.example.mytakeout.service.CategoryService;
import com.example.mytakeout.service.DishService;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 功能：
 * - 判断密码是否正确，用户是否存在
 * - 什么角色跳转到什么页面
 * - 是否记住密码？（返回一个状态？）
 */
@Slf4j
@Controller
@RequestMapping({ "/index", "/" })
public class IndexController {
    @Autowired
    SqlSessionFactory sessionFactory;
    @Autowired
    CategoryService categoryService;
    @Autowired
    DishService dishService;

    @PostConstruct
    private void postConstruct() {
        try {
            Category[] categories = {
                    new Category(null, "早餐", "早餐"),
                    new Category(null, "午餐", "午餐"),
                    new Category(null, "晚餐", "晚餐")
            };
            for (Category category : categories)
                categoryService.addCategory(category);
            Dish[][] dishes = { {
                    new Dish(null, "菜品1", "这是早餐的第一个菜品", null, 6d) },
                    {
                            new Dish(null, "菜品", "这是午餐的第一个菜品", null, 66d),
                            new Dish(null, "菜品", "这是午餐的第二个菜品，名字可以重复", null, 66d)
                    },
                    {
                            new Dish(null, "菜品c", "这是晚餐第一个菜品,免费", null, 0d)
                    }
            };
            for (int i =0 ;i<categories.length;++i) {
                for (Dish dish : dishes[i]) {
                    dishService.addDish(categories[i], dish);
                }
            }
        } catch (Exception e) {
            log.warn("添加初始菜品失败"+e);
        }
    }
    @GetMapping(" ")
    @ResponseBody
    public R<String> getMethodName() {
        return R.success("home");
    }
        
}
