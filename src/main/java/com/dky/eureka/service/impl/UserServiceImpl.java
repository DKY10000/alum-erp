package com.dky.eureka.service.impl;

import com.dky.eureka.persistence.user.UserMapper;
import com.dky.eureka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
}
