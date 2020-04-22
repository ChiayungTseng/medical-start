package com.medical.controller;

import com.medical.entity.DrugStock;
import com.medical.entity.Exchange;
import com.medical.entity.Stock;
import com.medical.mapper.DrugStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<Stock> query (@RequestBody Stock stock){
        List<Stock> query = drugStockMapper.query(stock.getBname());
        return query;
    }

    @RequestMapping("/sell")
    public Integer sell(@RequestBody Stock stock){
        int sell = stock.getStock();//应该减少的值
        int a = drugStockMapper.medicalstock(stock);
        int i = a - sell;
        stock.setStock(i);
        Integer updatestock = drugStockMapper.updatestock(stock);
        return updatestock;
    }

    @RequestMapping("/buy")
    public Integer buy(@RequestBody Stock stock){
        int i = 0;
        Integer updatestock = 0;
        int buy = stock.getStock();//购入的数量
        Stock querystock = drugStockMapper.querystock(stock);//查询仓库中药品的数量
        if (querystock == null){
            drugStockMapper.addstock(stock);
            stock.setStock(buy);
            updatestock = drugStockMapper.updatestock(stock);

        }else{
        i = querystock.getStock() + buy;
        stock.setStock(i);
        updatestock = drugStockMapper.updatestock(stock);
        }

        return updatestock;
    }

    @RequestMapping("/callout")
    public Integer callout(@RequestBody Exchange exchange){
        int calloutstock = exchange.getStock();//调出的数量
        int callout = drugStockMapper.calloutstock(exchange);//查询调出仓库中药品的数量
        int transferin = drugStockMapper.transferinstock(exchange); //查询调入仓库中药品的数量

        int c = callout - calloutstock;
        exchange.setStock(c);
        int updatecstock1 = drugStockMapper.updatecstock(exchange);

        int t = transferin + calloutstock;
        exchange.setStock(t);
        int updatettstock2 = drugStockMapper.updatettstock(exchange);

        int i = updatecstock1 + updatettstock2;

        return i;
    }

//    @RequestMapping("/transferin")
//    public Integer transferin(@RequestBody Exchange exchange){
//        int transferinstock = exchange.getStock();//调入的数量
//        int callout = drugStockMapper.calloutstock(exchange);//查询调出仓库中药品的数量
//        int transferin = drugStockMapper.transferinstock(exchange); //查询调入仓库中药品的数量
//
//        int c = callout - transferinstock;
//        exchange.setStock(c);
//        int updatecstock1 = drugStockMapper.updatecstock(exchange);
//
//        int t = transferin + transferinstock;
//        exchange.setStock(t);
//        int updatettstock2 = drugStockMapper.updatettstock(exchange);
//
//        int i = updatecstock1 + updatettstock2;
//
//        return i;
//    }




}
