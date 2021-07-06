package com.example.weTraveller.service.user;

import com.example.weTraveller.entity.User;
import com.example.weTraveller.service.AbstractService;


public interface UserService extends AbstractService<User> {

    public User findByPin(String pin);
    public User findByEmail(String email);
}
