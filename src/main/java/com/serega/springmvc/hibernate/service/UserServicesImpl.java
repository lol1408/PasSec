package com.serega.springmvc.hibernate.service;

import com.serega.springmvc.hibernate.dao.UserDao;
import com.serega.springmvc.hibernate.exception.EmailUsedException;
import com.serega.springmvc.hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sergey on 20.10.16.
 */
@Service
public class UserServicesImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        User newUser = null;
        if(user!=null){
            userDao.saveAndFlush(user);
        }
        else throw new NullPointerException();
    }

    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    @Override
    public User findById(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public User findByLogin(String login) {

        return userDao.findByLogin(login);
    }

    @Override
    public User findByMail(String mail) {
        return userDao.findByMail(mail);
    }

    @Override
    public void updateUser(User user) {
        userDao.saveAndFlush(user);
    }


}
