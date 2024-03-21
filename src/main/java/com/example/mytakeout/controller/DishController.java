package com.example.mytakeout.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.mytakeout.entity.Category;
import com.example.mytakeout.entity.Dish;
import com.example.mytakeout.service.DishService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/*
 * 对应给商家使用的用来管理菜品信息的页面
 * 功能：
 * -返回所有菜品信息
 */
@Slf4j
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("dish")
public class DishController {
    @Autowired
    DishService dishService;

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<String> handleException(Exception e) {
    // return
    // ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    // }

    @GetMapping("/{dishId}")
    public R<Dish> getDish(@PathVariable Integer dishId) {
        try {
            Dish dish = dishService.getDishById(dishId);
            return R.success(dish);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 在id为categoryId的菜单中添加菜品
     * 
     * @param categoryId
     * @param dish
     * @return
     */
    @PostMapping("/{categoryId}")
    public R<Dish> addDish(@PathVariable Integer categoryId, @RequestBody Dish dish) {
        try {
            Category category = new Category(categoryId, null, null);
            dish = dishService.addDish(category, dish);
            return R.success(dish);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }
    //TODO: 存储图片
    @PostMapping("/img/{dishId}")
    public R<String> addImg(@PathVariable Integer dishId, MultipartFile file) {
        try {
            log.info(file.getName());
            return R.success("su");
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 更新id 为dishId的菜品信息，null不更新
     * 
     * @param dishId
     * @param dish
     * @return
     */
    @PutMapping("")
    public R<Integer> updateDish(@RequestBody Dish dish) {
        try {
            Integer r = dishService.updateDish(dish);
            return R.success(r);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    @DeleteMapping("/{dishId}")
    public R<Dish> deleteDish(@PathVariable Integer dishId) {
        try {
            Dish dish = new Dish(dishId, null, null, null, null);
            dishService.deleteDish(dish);
            return R.success(dish);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

}
