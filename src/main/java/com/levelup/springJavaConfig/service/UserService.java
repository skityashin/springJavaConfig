package com.levelup.springJavaConfig.service;


import com.levelup.springJavaConfig.model.User;
import java.util.List;

public interface UserService {
    public User saveUser (User user);
    public void updateUser (User user);
    public User findById (long id);
    public List<User> getAllUsers ();

}
