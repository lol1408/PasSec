package com.serega.springmvc.hibernate.service;

import com.serega.springmvc.hibernate.model.User;

import java.util.List;

/**
 * Created by sergey on 20.10.16.
 */
public interface UserService {

    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(Long id);
    User findById(Long id);
    User findByLogin(String login);
    User findByMail(String mail);
    void updateUser(User user);


}
