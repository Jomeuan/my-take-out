package com.example.mytakeout.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mytakeout.entity.Category;
import com.example.mytakeout.mapper.CategoryMapper;
import com.example.mytakeout.service.CategoryService;
import com.example.mytakeout.utils.ExceptionUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Category addCategory(Category category) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
            categoryMapper.addCategory(category);
            session.commit();
            return category;
        } catch (Exception e) {
            String msg = e.getMessage();
            // categoryName 重复
            if (msg.contains("Duplicate"))
                throw new Exception("菜单名字重复");
            // TODO:数据格式不对（太长了、溢出了）
            // TODO: not
            else if (msg.contains("cannot be null")) {
                throw new Exception("属性不能为空");
            } else {
                log.error(msg, e);
                throw new Exception(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }
        }
    }

    /**
     * @return 菜单列表，异常时返回null
     */
    @Override
    public List<Category> getAllSorted() throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
            return categoryMapper.getAllSorted();
        }
        // 可能存在的异常：
        catch (Exception e) {
            String msg = e.getMessage();
            if (msg.contains("Duplicate"))
                throw new Exception("菜单名字重复");
            else {
                log.error(e.getMessage(), e);
                throw new Exception(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }

        }
    }
    private final String NOT_EXISIT = "不存在此菜单";
    private final String UPDATE_FAIL = "未能更新";
    private final String 
    @Override
    public String getIntroduction(Long id) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
            List<Category> list = categoryMapper.get("id", String.valueOf(id));
            if(list.size()==0)throw new Exception(NOT_EXISIT);
            return 
                    .get(0).getIntroduction();
        }
        // 可能存在的异常：没有此id的菜单
        catch (Exception e) {
            String msg = e.getMessage();
            if (msg.equals(UPDATE_FAIL))
                throw e;
            else if (msg.contains("Duplicate"))
                throw new Exception("菜单名字重复");
            else {
                log.error(e.getMessage(), e);
                throw new Exception(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }
        }
    }

    @Override
    public Integer updateCategory(Category category) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
            Integer r = categoryMapper.updateCategory(category);
            session.commit();
            if (r == 0)
                throw new Exception("未能更新");
            else
                return r;
        }
        // 可能存在的异常：没能更新
        catch (Exception e) {
            String msg = e.getMessage();
            if (msg.equals("未能更新"))
                throw e;
            else if (msg.contains("Duplicate"))
                throw new Exception("菜单名字重复");
            else {
                log.error(e.getMessage(), e);
                throw new Exception(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }

        }
    }

    @Override
    public Integer deleteCategory(Category category) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
            Integer r = categoryMapper.deleteCategoryById(category);
            session.commit();
            // 不能用r==0 判断是否删除成功
            // if (r == 0)
            // throw new Exception("未能删除");
            // else
            return r;
        } // 可能存在的异常：未能删除
        catch (Exception e) {
            if (e.getMessage().equals("未能删除"))
                throw e;
            else {
                log.error(e.getMessage(), e);
                throw new Exception(ExceptionUtils.UNKNOWN_EXCEPTION_MSG);
            }
        }
    }
}
