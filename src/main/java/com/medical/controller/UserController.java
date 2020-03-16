package com.medical.controller;

import com.medical.entity.vo.BaseResponseVo;
import com.medical.service.UserService;


import com.medical.utils.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public BaseResponseVo<String> login(@RequestParam("username")String username,@RequestParam("password")String password){
        return ResponseUtils.success(userService.login(username,password));
    }
}
