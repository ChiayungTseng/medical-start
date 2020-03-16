package com.medical.service;

import com.medical.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public String login(String userName,String password){
        return null;
    }
}
