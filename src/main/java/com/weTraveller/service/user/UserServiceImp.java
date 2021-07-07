package com.weTraveller.service.user;

import com.weTraveller.entity.User;
import com.weTraveller.exception.AlreadyExistException;
import com.weTraveller.exception.NotFoundException;
import com.weTraveller.exception.ServiceException;
import com.weTraveller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private Environment env;

    @Override
    public User create(User user) throws ServiceException {
        User _ex = this.findByPin(user.getPin());
        if(_ex != null) throw new AlreadyExistException();

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> userData = userRepository.findByEmail(email);
        return userData.isPresent() ? userData.get() : null;
    }

    @Override
    public User findByPin(String pin) {
        Optional<User> userData = userRepository.findByPin(pin);
        return userData.isPresent() ? userData.get() : null;
    }

    @Override
    public User update(long id, User user) throws ServiceException {
        User _ex = this.findById(id);
        if(_ex == null) throw new NotFoundException();
        return userRepository.save(user);
    }

    @Override
    public boolean delete(long id) throws ServiceException {
        User _ex = this.findById(id);
        if(_ex == null) throw new NotFoundException();

        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User findById(long id) {
        Optional<User> userData = userRepository.findById(id);
        return userData.isPresent() ? userData.get() : null;
    }
}
