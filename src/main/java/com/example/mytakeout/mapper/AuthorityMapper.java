package com.example.mytakeout.mapper;

import java.util.List;

import com.example.mytakeout.entity.Authority;

public interface AuthorityMapper {
    public List<String> getAuthorityByUserId(Integer userId);
    public void addAuthority(Authority authority);
}
