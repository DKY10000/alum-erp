package com.dky.eureka.persistence.user;

import com.dky.eureka.domain.user.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {
    List<User> selectByQueryModel();
}