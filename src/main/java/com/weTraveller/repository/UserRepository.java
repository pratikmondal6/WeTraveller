package com.weTraveller.repository;

import com.weTraveller.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPin(String pin);
    Optional<User> findByEmail(String email);


}
