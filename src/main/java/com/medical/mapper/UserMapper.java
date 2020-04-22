package com.medical.mapper;

import com.medical.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user(username,password,truename,usersex,usertellphone) " +
            "values(#{username},#{password},#{truename},#{usersex},#{usertellphone})")
    public void save(User user);

    @Select("select * from user where username=#{username} and password=#{password} ")
    User Identify(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username=#{username}")
    User verification(@Param("username") String username);



//    int deleteByPrimaryKey(Integer id);
//
//    int insert(User record);
//
//    int insertSelective(User record);
//
//    User selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);
}