package com.dky.eureka.persistence.user;

import com.dky.eureka.domain.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{
    public List<User> selectByQueryModel();
}