package com.dky.eureka.service;

import com.dky.eureka.domain.user.entity.User;

import java.util.List;

public interface IUserService {
    List<User> selectByQueryModel();
}
