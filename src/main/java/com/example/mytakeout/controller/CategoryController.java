package com.example.mytakeout.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mytakeout.entity.Category;
import com.example.mytakeout.entity.Dish;
import com.example.mytakeout.service.CategoryService;
import com.example.mytakeout.service.DishService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*
* 功能：
* -返回分类及其对应的菜品信息（给shopping页面使用）？还是分开,把菜品的部分给dishCrotroller
* -显示所有的分类（按page）
*
* -新增一条分类
*
* -移动某条分类的sort
* -修改某条分类的信息（名字，菜品，描述）
* 
* -删除一条分类

*/
@Slf4j
@RestController
// @CrossOrigin("http://localhost:3000")
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    DishService dishService;

    // 不要用 @GetMapping("/")
    @GetMapping("")
    public R<List<Category>> getAllCategory() {
        try {
            List<Category> list = categoryService.getAllSorted();
            return R.success(list);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    @GetMapping("/{categoryId}")
    public R<List<Dish>> getDishesByCategoryId(@PathVariable Integer categoryId) {
        try {
            List<Dish> list = dishService.getDishesByCategoryId(categoryId);
            return R.success(list);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }

    }

    @GetMapping("/{categoryId}/describe")
    public R<String> getCategoryDetail(@PathVariable Integer categoryId) {
        try {
            String s = categoryService.getDetail(categoryId);
            return R.success(s);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }

    }

    // 新建菜单 不做修改排序
    @PostMapping("")
    public R<Category> addCategory(@RequestBody Category category) {
        try {
            category = categoryService.addCategory(category);
            return R.success(category);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }

    }

    /**
     * 提供全部信息更新菜单
     * 
     * @param id
     * @param entity
     * @return
     */
    @PutMapping("")
    public R<Integer> updateCategory(@RequestBody Category category) {
        try {
            Integer r = categoryService.updateCategory(category);
            if (r == 0)
                return R.fail(r);
            else
                return R.success(r);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }
    // TODO: 是不是可以用{id}做为参数，在要删除多个数据时减少从前端过来的数据
    @DeleteMapping("/{categoryId}")
    R<Integer> deleteCategory(@PathVariable Integer categoryId){
        try {
            Category category = new Category(categoryId, null, null);
            Integer r = categoryService.deleteCategory(category);
            return R.success(r);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

}
