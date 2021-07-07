package com.weTraveller.entity;




import com.weTraveller.entity.common.CommonColumn;
import com.weTraveller.model.UserModel;

import javax.persistence.*;

@Entity
@Table(name = "users" )
public class User extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "password", length = 250)
    private String password;

    @Column(name = "pin", length = 10)
    private String pin;

    @Column(name = "active")
    private boolean active;


    public User(){

    }

    public User setUser(UserModel model){
        this.setId(model.getId());
        this.setName(model.getName());
        this.setEmail(model.getEmail());
        this.setPassword(model.getPassword());
        this.setActive(model.isActive());
        this.setPin(model.getPin());
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
