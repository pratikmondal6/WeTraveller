package com.example.weTraveller.security;

import com.example.weTraveller.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class AuthUser {

    private long id;
    private String name;
    private String pin;
    private String email;
    private String password;
    private boolean active;


    public AuthUser() {
    }

    public AuthUser(User user) {
        this.setId(user.getId());
        this.setName(user.getName().toLowerCase());
        this.setPin(user.getPin());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
