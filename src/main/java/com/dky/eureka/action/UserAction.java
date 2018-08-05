package com.dky.eureka.action;

import com.dky.eureka.domain.user.entity.User;
import com.dky.eureka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAction {
    @Autowired
    private IUserService iUserService;

    public List<User> getByQueryModel(){
        return iUserService.selectByQueryModel();
    }
}
