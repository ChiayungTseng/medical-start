package com.medical.controller;

import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
public class RegistController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/")
    public String register(){
        return "register";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String register(HttpServletRequest request){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.save(user);
        return "login";
  }




}
