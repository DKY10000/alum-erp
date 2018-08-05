package com.dky.eureka.action;

import com.dky.eureka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAction {
    @Autowired
    private IUserService iUserService;
}
