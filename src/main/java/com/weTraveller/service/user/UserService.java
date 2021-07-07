package com.weTraveller.service.user;


import com.weTraveller.entity.User;
import com.weTraveller.service.AbstractService;

public interface UserService extends AbstractService<User> {

    public User findByPin(String pin);
    public User findByEmail(String email);
}
