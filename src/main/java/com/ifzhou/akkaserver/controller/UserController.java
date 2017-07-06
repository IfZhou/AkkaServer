package com.ifzhou.akkaserver.controller;

import com.ifzhou.akkaserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouyifu on 2017/7/6.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String handle(){
        return "ddd";
    }


    @RequestMapping("/test1")
    @ResponseBody
    public String test1(){
        Object result=userService.send("hahaha");
        return "ddd";
    }
}
