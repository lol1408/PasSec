package com.serega.springmvc.hibernate.service;

import com.serega.springmvc.config.DataBaseConfigTest;
import com.serega.springmvc.hibernate.model.Resource;
import com.serega.springmvc.hibernate.model.User;
import com.serega.springmvc.hibernate.util.DataUtil;
import com.serega.springmvc.hibernate.util.UserFactory;
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

/**
 * Created by sergey on 14.11.16.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataBaseConfigTest.class)
@WebAppConfiguration
@Transactional
public class UserServiceTest extends Assert{
        @javax.annotation.Resource
        private EntityManagerFactory emf;
        private EntityManager em;

        @javax.annotation.Resource
        UserService userService;

        @javax.annotation.Resource
        ResourceService resourceService;


        List<User> users;
        List<Resource> resources;

        @Before
        public void setUp() throws Exception{
            users = new ArrayList<>();
            resources = new ArrayList<>();
            em = emf.createEntityManager();
            DataUtil.initDb(resources, resourceService, users, userService);

        }
        //Tests of function for add user
        @Test
        public void testSaveUser(){
            userService.addUser(UserFactory.createUser("lol2222", "0000", "email2"));
        }
        @Test(expected = NullPointerException.class)
        public void testSaveNullUser()
        {
            userService.addUser(null);
        }
        @Test(expected = JpaSystemException.class)
        public void testAddCreatedUser(){
            userService.addUser(UserFactory.createUser("lol1111", "0000", "email"));
        }
        @Test(expected = JpaSystemException.class)
        public void testAddUserAlreadyUseEmail(){
            userService.addUser(UserFactory.createUser("lol1111", "0000", "email"));
        }
        @Test(expected = JpaSystemException.class)
        public void testNullLogin(){
            userService.addUser(UserFactory.createUser(null, "0000", "email2"));
        }
        @Test(expected = JpaSystemException.class)
        public void testNullPassword(){
            userService.addUser(UserFactory.createUser("lol2222", null, "email2"));
        }
        @Test(expected = JpaSystemException.class)
        public void testNullEmail(){
            userService.addUser(UserFactory.createUser("lol2222", "0000", null));
        }

        //Tests for function of select all user
        @Test
        public void getAllUsers() {
            List<User> allUsers = userService.getAllUsers();
            assert (allUsers.size() == users.size());
            for (int i = 0; i < allUsers.size(); i++) {
                assertEquals(allUsers.get(i), users.get(i));
            }
        }
        @Test
        public void getAllUsersNeverRecord(){
            DataUtil.dropDb(userService, resourceService, users, resources);
            assertTrue(userService.getAllUsers().size()==0);
            DataUtil.initDb(resources, resourceService, users, userService);
        }
        @After
        public void afterMethod(){
            DataUtil.dropDb(userService, resourceService, users, resources);
        }

}
