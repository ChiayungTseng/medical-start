package com.medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

    @RequestMapping("/{path}*.html")
    public String door(@PathVariable("path")String path){
        return path;
    }
}
