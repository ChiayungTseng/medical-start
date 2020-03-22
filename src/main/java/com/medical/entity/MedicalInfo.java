package com.medical.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Property;

import java.util.Date;

@Data
public class MedicalInfo {
    private  Integer mid;
    private  String mname;
    private String mtype;
    private Date mbirth;
    private Float mbuy;
    private Float msell;


}
