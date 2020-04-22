package com.medical.mapper;

import com.medical.entity.Branch;
import com.medical.entity.MedicalInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BranchMapper {
    @Select("select * from branch ")
/*    @Results({
            @Result(column = "medical_id",property = "medicalId"),
            @Result(column = "medical_name",property = "medicalName"),
    })*/
    List<Branch> select();

    @Select("select * from branch where bid = #{bid}")
    Branch selectByBid(@Param("bid") Integer bid);

    @Select("select bname from branch")
    List<Branch> querybname();

    @Insert("insert into branch(bid,bname,baddress,btellphone)" +
            "values (#{branch.bid},#{branch.bname},#{branch.baddress},#{branch.btellphone})")
    public void save(@Param("branch")Branch branch);

    @Update("update branch set bname = #{branch.bname},baddress = #{branch.baddress}," +
            "btellphone = #{branch.btellphone} where bid = #{branch.bid}")
    int update(@Param("branch") Branch branch);

    @Delete("delete from branch where bid = #{branch.bid}")
    int delete(@Param("branch") Branch branch);

}
