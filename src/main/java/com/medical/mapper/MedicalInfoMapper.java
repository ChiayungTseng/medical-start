package com.medical.mapper;

import com.medical.entity.MedicalInfo;
import com.medical.entity.User;
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

    @Insert("insert into user(username,password) values(#{username},#{password})")
    public void save(MedicalInfo user);
}
