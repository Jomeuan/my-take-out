package com.example.mytakeout.service;

import java.util.List;

import com.example.mytakeout.entity.Category;

public interface CategoryService {
    /**
     * TODO: 重名时抛错
     * 
     * @param category
     * @return
     */
    public Category addCategory(Category category) throws Exception;

    public List<Category> getAllSorted() throws Exception;

    public String getDetail(Integer id) throws Exception;

    /**
     * 不需要修改的字段设置为空，注意id应当为空
     * 
     * @param category
     * @return 成功update的数据的条数
     */
    public Integer updateCategory(Category category) throws Exception;

    public Integer deleteCategory(Category category)throws Exception;

}
