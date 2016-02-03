//package com.levelup.springJavaConfig.repository.impl;
//
//
//import com.levelup.springJavaConfig.model.User;
//import com.levelup.springJavaConfig.repository.UserRepository;
//import org.springframework.stereotype.Repository;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.List;
//
//@Repository
//public class UserRepositoryImpl implements UserRepository{
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public User saveUser(User user) {
//        entityManager.persist(user);
//        return user;
//    }
//
//    @Override
//    public void updateUser(User user) {
//        entityManager.merge(user);
//    }
//
//    @Override
//    public User findById(long id) {
//        return entityManager.find(User.class, id);
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        Query query = entityManager.createQuery("from User");
//        return query.getResultList();
//    }
//
//}
