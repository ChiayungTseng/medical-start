package com.medical.controller;

import com.medical.entity.Dindang;
import com.medical.entity.MedicalInfo;
import com.medical.mapper.MedicalInfoMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/medicalinfo")
public class MedicalController {
    @Resource
    private MedicalInfoMapper medicalInfoMapper;

    @RequestMapping("/query")
    public List<MedicalInfo> query(){
        List<MedicalInfo> medicalList = medicalInfoMapper.select();
        return medicalList;
    }

    @RequestMapping("/queryshop")
    public List<MedicalInfo> queryshop(){
        List<MedicalInfo> medicalList = medicalInfoMapper.selectshop();
        return medicalList;
    }

    @RequestMapping("/queryByMcodeOrMname")
    public MedicalInfo selectByMcodeOrMname(@RequestBody MedicalInfo medicalInfo){
            if(medicalInfo!=null){
                MedicalInfo medicalInfo1 = medicalInfoMapper.selectByMcodeOrMname("medicalInfo.getMid()");
            }
            return medicalInfo;
    }

    @RequestMapping("/add")
    public String add(@RequestBody MedicalInfo medicalInfo){
         MedicalInfo dbMedicalInfo = medicalInfoMapper.verification(medicalInfo.getMcode());
        if (dbMedicalInfo!=null){
            return "此药品已存在";
        }else {
            if(medicalInfo.getMbirth()==null)medicalInfo.setMbirth(new Date());
            if(medicalInfo.getMbuy()==null)medicalInfo.setMbuy(0f);
            if(medicalInfo.getMsell()==null)medicalInfo.setMsell(0f);
            medicalInfoMapper.save(medicalInfo);
            return "medicalInfo";
        }

    }

    @RequestMapping("/update")
    public Integer update(@RequestBody MedicalInfo medicalInfo){
        Integer row = 0;

        int updateRow = medicalInfoMapper.update(medicalInfo);
        row = row+updateRow;

        return row;
    }

    @RequestMapping("/delete")
    public Integer delete(@RequestBody MedicalInfo[] medicalInfos){
        Integer row = 0;

        for(MedicalInfo medicalInfo:medicalInfos){
            int deleteRow = medicalInfoMapper.delete(medicalInfo);
            row = row+deleteRow;
        }
        return row;
    }


}
