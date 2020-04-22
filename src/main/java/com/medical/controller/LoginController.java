package com.medical.controller;

import com.medical.entity.User;
import com.medical.mapper.UserMapper;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class LoginController {
    @Resource
    private UserMapper userMapper;
    @GetMapping("/login")
    public String Login(){

        return "login";
    }
    @RequestMapping("/addLogin")
    @Transactional
    public String addLogin(@RequestBody User user, HttpServletResponse response){

        user= userMapper.Identify(user.getUsername(),user.getPassword());
        if(user!=null){
            response.addCookie(new Cookie("userId",user.getUserid().toString()));
            return "登录成功";
        }else{
            return "登录失败";
        }

    }



}
