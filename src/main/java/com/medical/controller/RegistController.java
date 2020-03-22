package com.medical.controller;

import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class RegistController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/")
    public String register(){

        return "register";
    }

    @RequestMapping("/addUser")
    public String register(@RequestParam("username")String username,@RequestParam("password")String password){
        User user = userMapper.verification(username);
        if(user!=null){
            return "register";
        }else {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userMapper.save(user);
            return "login";
        }
    }

  }





