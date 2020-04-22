package com.medical.controller;

import com.medical.entity.Empinfo;
import com.medical.mapper.EmpinfoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/empinfo")
public class EmpInfoController {
    @Resource
    private  EmpinfoMapper empinfoMapper;

    @RequestMapping("/query")
    public List<Empinfo> query(){
        List<Empinfo> select = empinfoMapper.select();
        return select;
    }

    @RequestMapping("/queryByEid")
    public  Empinfo queryByEid(@RequestBody Empinfo empinfo){
        Empinfo empinfo1 = empinfoMapper.selectByEid(empinfo.getEid());
        return empinfo1;
    }


    @RequestMapping("/add")
    public String add(@RequestBody Empinfo empinfo ){
        Empinfo dbempinfo1 = empinfoMapper.selectByEid(empinfo.getEid());

        if(dbempinfo1!=null){
            return "此员工已存在";
        }else {
            if(empinfo.getSex()==null)empinfo.setSex("男");
            empinfoMapper.add(empinfo);
            return "empinfo";
        }

    }

    @RequestMapping("/update")
    public Integer update(@RequestBody Empinfo empinfo){
        Integer row = 0;
        int updateRow = empinfoMapper.update(empinfo);
        row = row+updateRow;
        return row;
    }

    @RequestMapping("/delete")
    public Integer delete(@RequestBody Empinfo[] empinfos){
        Integer row = 0;
        for(Empinfo empinfo:empinfos){
            int deleteRow = empinfoMapper.delete(empinfo);
            row = row+deleteRow;
        }

        return row;
    }

}
