package com.serega.springmvc.hibernate.service;


import com.serega.springmvc.config.DataBaseConfigTest;
import com.serega.springmvc.hibernate.model.Resource;
import com.serega.springmvc.hibernate.model.User;
import com.serega.springmvc.hibernate.util.DataUtil;
import com.serega.springmvc.hibernate.util.ResourcesFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataBaseConfigTest.class)
@WebAppConfiguration
@Transactional
public class ResourceServiceTest extends Assert{

    @javax.annotation.Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @javax.annotation.Resource
    UserService userService;

    @javax.annotation.Resource
    ResourceService resourceService;

    List<Resource> resources;
    List<User> users;

    @Before
    public void setUp() throws Exception{
        users = new ArrayList<>();
        resources = new ArrayList<>();
        em = emf.createEntityManager();
        DataUtil.initDb(resources, resourceService, users, userService);

    }

    @Test
    public void addResource(){
        resourceService.addResource(ResourcesFactory.createHelloResource(users.get(1)));
    }
    @Test(expected = NullPointerException.class)
    public void addResourceUserIsNull(){
        resourceService.addResource(ResourcesFactory.createHelloResource(null));
    }
    @Test(expected = JpaSystemException.class)
    public void addResourceLoginIsNull(){
        resourceService.addResource(ResourcesFactory.createResources("hello.com",
                null, "0000", users.get(1)));
    }
    @After
    public void afterMethod(){
        DataUtil.dropDb(userService, resourceService, users, resources);
    }

}
