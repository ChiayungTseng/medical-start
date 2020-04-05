package com.medical.mapper;

import com.medical.entity.MedicalInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MedicalInfoMapper {


    @Select("select * from medicalinfo ")
/*    @Results({
            @Result(column = "medical_id",property = "medicalId"),
            @Result(column = "medical_name",property = "medicalName"),
    })*/
    List<MedicalInfo> select();

    @Select("select * from medicalinfo where mcode= #{mcode} " )
    MedicalInfo verification(@Param("mcode") String mcode);

    @Select("select * from medicalinfo where mid = #{mid}")
    MedicalInfo selectByMid(@Param("mid") Integer mid);

    @Select("select * fron medicalinfo where mcode LIKE concat(cancat('%',#{mcode}),'%')")
    MedicalInfo selectByMcodeOrMname(@Param("mid") String mid);


    @Insert( "insert into medicalinfo(mcode,mname,mtype,mbirth,mbuy,msell) " +
            "values (#{medicalinfo.mcode},#{medicalinfo.mname},#{medicalinfo.mtype},#{medicalinfo.mbirth},#{medicalinfo.mbuy},#{medicalinfo.msell})")
    public void save(@Param("medicalinfo")MedicalInfo medicalInfo);

    @Update("update medicalinfo set mcode = #{medicalinfo.mcode},mname = #{medicalinfo.mname}," +
            "mtype = #{medicalinfo.mtype},mbirth = #{medicalinfo.mbirth},mbuy = #{medicalinfo.mbuy},msell = #{medicalinfo.msell} where mid = #{medicalinfo.mid}")
//    UPDATE medicalinfo set mtype="obc" WHERE mid=1;
    int update(@Param("medicalinfo")MedicalInfo medicalInfo);

    @Delete("delete from medicalinfo where mid=#{medicalinfo.mid}")
     int delete(@Param("medicalinfo") MedicalInfo medicalInfo);



}

