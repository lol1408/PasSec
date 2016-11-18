package com.serega.springmvc.hibernate.util;


import com.serega.springmvc.hibernate.model.User;

/**
 * Resource util
 */
public class UserFactory {

    public static User createUser(String login, String password, String mail){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setMail(mail);
        return user;
    }

}
