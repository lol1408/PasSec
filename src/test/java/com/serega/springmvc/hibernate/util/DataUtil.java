package com.serega.springmvc.hibernate.util;

import com.serega.springmvc.hibernate.model.Resource;
import com.serega.springmvc.hibernate.model.User;
import com.serega.springmvc.hibernate.service.ResourceService;
import com.serega.springmvc.hibernate.service.UserService;

import java.util.List;


public class DataUtil {

    public static void initDb(List<Resource> resources,
                              ResourceService resourceService,
                              List<User> users,
                              UserService userService){
        users.clear();
        resources.clear();
        //Add user to collection users
        users.add(UserFactory.createUser("lol1111","0000","email"));
        users.add(UserFactory.createUser("lol0000","1111","email1"));

        //Add users to database
        userService.addUser(users.get(0));
        userService.addUser(users.get(1));
        User user1 = userService.findByLogin("lol1111");
        User user2 = userService.findByLogin("lol0000");
        //Add records to collection resources
        resources.add(ResourcesFactory.createResources("vk.com",
                "lalka4444", "0000", userService.findByLogin("lol1111")));
        resources.add(ResourcesFactory.createResources("ok.com",
                "mamka4444", "1111", userService.findByLogin("lol0000")));

        //Add resources to database
        resourceService.addResource(resources.get(0));
        resourceService.addResource(resources.get(1));
        users = userService.getAllUsers();
        resources = resourceService.getAllResources();
    }
    public static void dropDb(UserService userService, ResourceService resourceService,
                              List<User> allUsers, List<Resource> allResources){
        for (Resource resource:allResources){
             resourceService.deleteResources(resource.getIdResource());
        }
        for(User user:allUsers){
            userService.deleteUser(user.getIdUser());
        }

    }

}
