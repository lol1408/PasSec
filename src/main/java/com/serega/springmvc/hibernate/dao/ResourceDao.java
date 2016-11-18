package com.serega.springmvc.hibernate.dao;

import com.serega.springmvc.hibernate.model.Resource;
import com.serega.springmvc.hibernate.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ResourceDao extends JpaRepository<Resource, Long> {
    List<Resource> findByUser(User user);
}
