package com.serega.springmvc.hibernate.dao;

import com.serega.springmvc.hibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sergey on 20.10.16.
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByLogin(String login);
    User findByMail(String mail);
}
