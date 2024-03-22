package com.example.mytakeout.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.mytakeout.entity.Category;

public interface CategoryMapper {
    /**
     * 增加
     * @param category
     * @throws Exception
     */
    public void addCategory(Category category) throws Exception;

    /**
     * 删除category，category对应的dish ，外键<category,dish>
     * @param category
     * @return
     * @throws Exception
     */
    public int deleteCategory(Category category) throws Exception;

    public int updateCategory(Category category) throws Exception;

    /**
     * eg. List<Category> get("category_name","早餐")
     * 
     * @param colName
     * @param value
     * @return
     */
    public List<Category> get(@Param("columnName") String colName, @Param("value") String value);

    public List<Category> getAllSorted() throws Exception;
}
