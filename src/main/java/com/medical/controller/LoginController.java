package com.medical.controller;

import com.medical.entity.User;
import com.medical.mapper.UserMapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    private UserMapper userMapper;
    @GetMapping("/login")
    public String Login(){

        return "login";
    }
    @RequestMapping("/addlogin")
    public String login(HttpServletRequest request , Model model, Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userMapper.Identify(username,password);

        System.out.print("111111");
        if(user!=null){
            model.addAttribute("user",username);
            map.put("msg","登录成功");
            return "index";
        }else{
            map.put("msg","登录失败");
            return "login";
        }

    }
}
