package com.example.mytakeout.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mytakeout.entity.Authority;

public interface AuthorityMapper {

    /**
     * TODO：测试 可以不可以 用column=1,value=1 来实现getall
     * 
     * @param column
     * @param value
     * @return
     */
    public List<Authority> get(
            @Param("column") String column,
            @Param("value") String value);

    public int addAuthority(Authority authority);
    
    //TODO: public int deleteAuthority

    public int updateAuthority(Authority authority);
}
