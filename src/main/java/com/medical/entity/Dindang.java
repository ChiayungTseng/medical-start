package com.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Dindang {

        private Integer orderid;
        private Integer userid;
        private Integer amount;
        private Integer total;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date orderdate;
        private String orderaddress;
        private String usertellphone;
        List<DindangInfo> dindangInfoList;//药品订单
    }


