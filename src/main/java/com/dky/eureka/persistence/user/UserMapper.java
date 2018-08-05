package com.dky.eureka.persistence.user;

import com.dky.eureka.domain.user.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {
}