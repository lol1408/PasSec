package com.serega.springmvc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.serega.springmvc.hibernate.model.AjaxResponseBody;
import com.serega.springmvc.hibernate.model.Resource;
import com.serega.springmvc.hibernate.model.User;
import com.serega.springmvc.hibernate.service.ResourceService;
import com.serega.springmvc.hibernate.service.UserService;
import com.serega.springmvc.util.Convert;
import com.serega.springmvc.web.jsonview.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by sergey on 31.10.16.
 */
@RestController
@RequestMapping("/")
@Transactional
public class MainRestController {
    @Autowired
    ResourceService resourceService;
    @Autowired
    UserService userServices;

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public AjaxResponseBody addUser(@RequestBody User jsonUser) throws IOException {
        AjaxResponseBody result = new AjaxResponseBody();
        User user = jsonUser;
        if(userServices.findByLogin(user.getLogin())!=null){
            result.setCode("204");
            result.setMsg("Пользователь с данным логином существует");
            return result;
        }else if (userServices.findByMail(user.getMail())!=null){
            result.setCode("204");
            result.setMsg("Пользователь с данным элекронным адресом уже существует");
            return result;
        }
        else{
            result.setMsg("Пользователь добавлен");
            result.setCode("200");
            result.setResult(user);
            userServices.addUser(user);
            return result;
        }

    }
    //Добавление записи
    @RequestMapping(value = "/addresource", method = RequestMethod.POST)
    public AjaxResponseBody addResource(@RequestBody Resource json) {
        AjaxResponseBody result = new AjaxResponseBody();
        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            Resource resource = json;
            User byLogin = userServices.findByLogin(user.getUsername());
            resource.setUser(byLogin);
            resourceService.addResource(resource);
            result.setCode("200");
            result.setMsg("Ваша запись успешно добавлена");

        } catch (Exception e) {
            result.setCode("202");
            result.setMsg("Ну удалось преобразовать запись в json объект");
            e.printStackTrace();
        }
        return result;
    }

    //Возвращает json объекты со всеми записями оприделенного пользователя
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Resource> allResource(){
        //List<Resource> allResources = resourceService.getAllUsers();
        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user2 = userServices.findByLogin(user.getUsername());
        List<Resource> allResources = resourceService.findByUser(user2);


        return allResources;
    }

    //Возвращает первого пользователя
    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
    public User getFirstUser(@PathVariable("idUser") Long id, Model model){
        User user = userServices.findById(id);
        return user;
    }

}
