package com.serega.springmvc.web.controller;

import com.serega.springmvc.hibernate.service.ResourceService;
import com.serega.springmvc.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    ResourceService resourceService;
    @Autowired
    UserService userServices;
    @RequestMapping(method = RequestMethod.GET)
    public String indexPage(ServletRequest servletRequest) throws UnsupportedEncodingException {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            return "resources";}
        else return "index";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(ServletRequest servletRequest) {
        return "registration";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }
}
