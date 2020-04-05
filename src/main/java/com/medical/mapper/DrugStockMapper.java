package com.medical.mapper;

import com.medical.entity.DrugStock;
import com.medical.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DrugStockMapper {

    @Select("SELECT bname,m.mcode,mname,mtype,stock\n" +
            "FROM medicalinfo AS m\n" +
            "INNER JOIN drugstock AS d\n" +
            "ON d.mcode = m.mcode\n" +
            "INNER JOIN branch AS b\n" +
            "ON b.bid = d.bid\n")
    List<Stock> queryall();

    @Select("SELECT bname,m.mcode,mname,mtype,stock\n" +
            "FROM medicalinfo AS m\n" +
            "INNER JOIN drugstock AS d\n" +
            "ON d.mcode = m.mcode\n" +
            "INNER JOIN branch AS b\n" +
            "ON b.bid = d.bid\n"+
            "where bname = #{branch.bname}")
    List<Stock> query();



}
