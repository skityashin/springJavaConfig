package com.levelup.springJavaConfig.service.impl;


import com.levelup.springJavaConfig.model.User;
import com.levelup.springJavaConfig.repository.UserRepository;
import com.levelup.springJavaConfig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return userRepository.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
