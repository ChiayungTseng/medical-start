package com.medical.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.annotations.Property;

import java.util.Date;

@Data
public class MedicalInfo {
    private  Integer mid;
    private String mcode;
    private  String mname;
    private String mtype;

   @JsonFormat(pattern = "yyyy-MM-dd HH:ss")
    private Date mbirth;
    private Float mbuy;
    private Float msell;


}
