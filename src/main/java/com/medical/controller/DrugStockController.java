package com.medical.controller;

import com.medical.entity.DrugStock;
import com.medical.entity.Stock;
import com.medical.mapper.DrugStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/drugstock")
public class DrugStockController {

    @Resource
    private  DrugStockMapper drugStockMapper;

    @RequestMapping("/queryall")
    public List<Stock> queryall (){
        List<Stock> query = drugStockMapper.queryall();
        return query;
    }

    @RequestMapping("/query")
    public List<Stock> query (){
        List<Stock> query = drugStockMapper.query();
        return query;
    }
}
