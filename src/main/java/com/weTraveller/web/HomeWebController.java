package com.weTraveller.web;


import com.weTraveller.security.SpringSecurityUtil;
import com.weTraveller.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Controller
public class HomeWebController {

    @Autowired
    private Environment env;

    @Autowired
    private SpringSecurityUtil springSecurityUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private SpringTemplateEngine thymeleafTemplateEngine;

    @GetMapping("/")
    public Object index() {
        return "post";
    }



}
