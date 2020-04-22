package com.medical.controller;

import com.medical.entity.Dindang;
import com.medical.entity.DindangInfo;
import com.medical.entity.MedicalInfo;
import com.medical.mapper.DindangMapper;
import com.medical.mapper.MedicalInfoMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private DindangMapper dindangMapper;
    private MedicalInfoMapper medicalInfoMapper;

    @RequestMapping("/query")
    public List<DindangInfo> query(){
        List<DindangInfo> select = dindangMapper.select();
        return select;
    }

//插入订单信息
    @RequestMapping("/dindang")
    public Integer dindang(@RequestBody Dindang dindang){
        if (dindang.getOrderdate()==null)dindang.setOrderdate(new Date());
        int buyorder = dindangMapper.buyorder(dindang);
        int dindanginfo = 0;
        List<DindangInfo> dindangInfoLists = dindang.getDindangInfoList();
        for(DindangInfo dindangInfo:dindangInfoLists){
             dindanginfo = dindangMapper.dindanginfo(dindangInfo);
        }
        int a=buyorder+dindanginfo;
        return a;
    }
//
//    @RequestMapping("/add")
//    public String add(@RequestBody Dindang dindang){
//        int i = 0;
//        int b = dindang.getOrderbuy();
//        int search = dindangMapper.search(dindang.getMname());
//        i = search * b;
//        dindang.setCount(i);
//        dindangMapper.save(dindang);
//        return "dindang";
//    }
}

