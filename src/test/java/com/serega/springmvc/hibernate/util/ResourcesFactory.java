package com.serega.springmvc.hibernate.util;


import com.serega.springmvc.hibernate.model.Resource;
import com.serega.springmvc.hibernate.model.User;

public class ResourcesFactory {

    public static Resource createResources(String name, String login,
                                           String password,
                                           User user){
        Resource resource = new Resource();
        resource.setLogin(name);
        resource.setPassword(login);
        resource.setNameResource(password);
        resource.setUser(user);
        return resource;

    }
    public static Resource createHelloResource(User user){
        Resource resource = new Resource();
        resource.setLogin("hello");
        resource.setPassword("0000");
        resource.setNameResource("hello.com");
        resource.setUser(user);
        return resource;
    }


}
