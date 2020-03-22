package com.medical.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medical")
public class MedicalController {

    @RequestMapping("/query")
    public List<Medical> query(){
        List<Medical> medicalList = new ArrayList<>();
        medicalList.add(new Medical("ss","yy","sss"));
        return medicalList;
    }

    @RequestMapping("/add")
    public Integer add(@RequestBody Medical medical){
        System.out.println(JSON.toJSONString(medical));
        return 1;
    }

    @RequestMapping("/save")
    public Integer add(@RequestBody List<Medical> medicalList){
        System.out.println(JSON.toJSONString(medicalList));
        return 1;
    }

    @RequestMapping("/delete")
    public Integer delete(@RequestBody List<Medical> medicalList){
        System.out.println(JSON.toJSONString(medicalList));
        return 1;
    }


}
class Medical{
    public Medical() {
    }

    public Medical(String code, String name, String date) {
        this.code = code;
        this.name = name;
        this.date = date;
    }

    public String code;

    public String name;

    public String date;
}