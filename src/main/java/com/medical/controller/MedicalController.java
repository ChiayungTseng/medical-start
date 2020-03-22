package com.medical.controller;

import com.alibaba.fastjson.JSON;
import com.medical.entity.MedicalInfo;
import com.medical.mapper.MedicalInfoMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/medical")
public class MedicalController {
    @Resource
    private MedicalInfoMapper medicalInfoMapper;

    @RequestMapping("/query")
    public List<MedicalInfo> query(){
        List<MedicalInfo> medicalList = medicalInfoMapper.select();
        return medicalList;
    }

    @RequestMapping("/add")
    public Integer add(@RequestBody MedicalInfo medical){
        System.out.println(JSON.toJSONString(medical));


        return 1;
    }

    @RequestMapping("/save")
    public Integer add(@RequestBody List<MedicalInfo> medicalList){
        System.out.println(JSON.toJSONString(medicalList));
        return 1;
    }

    @RequestMapping("/delete")
    public Integer delete(@RequestBody List<MedicalInfo> medicalList){
        System.out.println(JSON.toJSONString(medicalList));
        return 1;
    }


}
