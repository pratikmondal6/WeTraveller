package com.weTraveller.model;


import com.weTraveller.entity.User;

public class UserModel {

    private long id;
    private String name;
    private String email;
    private String password;
    private String pin;
    private boolean active;


    public UserModel(User entity) {
        this.setId(entity.getId());
        this.setName(entity.getName());
        this.setEmail(entity.getEmail());
        this.setPassword(entity.getPassword());
        this.setActive(entity.isActive());
        this.setPin(entity.getPin());
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
