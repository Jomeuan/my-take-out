package com.example.mytakeout.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.mytakeout.entity.Category;

public interface CategoryMapper {
    public void addCategory(Category category) throws Exception;

    public int deleteCategoryById(Category category) throws Exception;

    public List<Category> getAllSorted() throws Exception;

    public Category getById(Integer id) throws Exception;

    public Category getByName(String name) throws Exception;

    public int updateCategory(Category category) throws Exception;

    /**
     * eg. List<Category> get("category_name","早餐")
     * 
     * @param colName
     * @param value
     * @return
     */
    public List<Category> get(@Param("columnName") String colName, @Param("value") String value);
}
