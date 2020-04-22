package com.medical.controller;

import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class RegisterController {

    @Resource
    private UserMapper userMapper;

//    @GetMapping("/")
//    public String register(){
//
//        return "register";
//    }

    @RequestMapping("/register")
    public String register(@RequestBody User user){
        User verification = userMapper.verification(user.getUsername());
        if (verification != null){
            return "该用户已存在";
        }else {
            userMapper.save(user);
            return"注册成功";
        }
    }
}
