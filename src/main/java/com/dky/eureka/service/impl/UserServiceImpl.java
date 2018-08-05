package com.dky.eureka.service.impl;

import com.dky.eureka.domain.user.entity.User;
import com.dky.eureka.persistence.user.UserMapper;
import com.dky.eureka.service.IUserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectByQueryModel() {
        return userMapper.selectByQueryModel();
    }
}
