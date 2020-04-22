package com.medical.mapper;

import com.medical.entity.Branch;
import com.medical.entity.Dindang;
import com.medical.entity.DindangInfo;
import com.medical.entity.MedicalInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DindangMapper {

    @Select("SELECT medicalinfo.mname,medicalinfo.msell,dindanginfo.amount\n" +
            "FROM medicalinfo\n" +
            "LEFT JOIN  dindanginfo\n" +
            "ON medicalinfo.mname = dindanginfo.mname")
/*    @Results({
            @Result(column = "medical_id",property = "medicalId"),
            @Result(column = "medical_name",property = "medicalName"),
    })*/
    List<DindangInfo> select();

    @Select("SELECT medicalinfo.mname,msell,amount,total \n" +
            "FROM medicalinfo\n" +
            "LEFT JOIN dindang\n" +
            "ON medicalinfo.mname = dindang.mname\n")
    List<Dindang> buygoods();

    @Select("select distinct msell FROM medicalinfo \n" +
            "INNER JOIN dindang\n" +
            "WHERE medicalinfo.mname = #{bname}")
    int search(@Param("bname") String bname);

    @Insert("insert into dindang(bname,mname,orderbuy,count,orderdate,orderaddress) values(#{bname},#{mname},#{orderbuy},#{count},#{orderdate},#{orderaddress})")
    public void save(Dindang dindang);

    @Insert("insert into dindang(orderaddress,usertellphone) " +
            "values(#{orderaddress},#{usertellphone})")
    int buyorder(Dindang dindang);

    @Insert("insert into dindanginfo(orderid,mname,amount,msell) " +
            "values(#{orderid},#{mname},#{amount},#{msell})")
    int dindanginfo(DindangInfo dindangInfo);

    @Update("update dindang set count = #{count} where orderid = #{orderid})")
    int count(@Param("count") Integer count);
}
