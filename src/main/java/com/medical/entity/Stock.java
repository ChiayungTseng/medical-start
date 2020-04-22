package com.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Stock {

    private Integer bid;
    private String bname;
    private String mcode;
    private String mname;
    private String mtype;
    private Integer stock;


}
