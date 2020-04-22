package com.medical.mapper;

import com.medical.entity.Empinfo;
import com.medical.entity.MedicalInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpinfoMapper {
    @Select("select * from empinfo order by eid")
/*    @Results({
            @Result(column = "medical_id",property = "medicalId"),
            @Result(column = "medical_name",property = "medicalName"),
    })*/
    List<Empinfo> select();

    @Select("select * from empinfo where eid = #{eid}")
    Empinfo selectByEid(@Param("eid") Integer eid);


    @Insert("insert into empinfo(eid,ename,sex,etellphone,eaddress,ejob,bname) " +
            "values(#{empinfo.eid},#{empinfo.ename},#{empinfo.sex},#{empinfo.etellphone},#{empinfo.eaddress},#{empinfo.ejob},#{empinfo.bname})")
    public void add(@Param("empinfo") Empinfo empinfo);

    @Update("update empinfo set ename = #{empinfo.ename},sex = #{empinfo.sex},etellphone = #{empinfo.etellphone}," +
            "eaddress = #{empinfo.eaddress},ejob = #{empinfo.ejob},bname = #{empinfo.bname} where eid = #{empinfo.eid}")
    int update (@Param("empinfo") Empinfo empinfo);

    @Delete("delete from empinfo where eid = #{empinfo.eid}")
    int delete(@Param("empinfo") Empinfo empinfo);


}
