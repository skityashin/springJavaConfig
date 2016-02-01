package com.levelup.springJavaConfig.repository;



import com.levelup.springJavaConfig.model.User;
import java.util.List;

public interface UserRepository {
    public User saveUser (User user);
    public void updateUser (User user);
    public User findById (long id);
    public List<User> getAllUsers ();

}
