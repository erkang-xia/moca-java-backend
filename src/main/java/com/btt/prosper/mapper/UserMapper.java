package com.btt.prosper.mapper;

import com.btt.prosper.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> list();

    @Select("select * from user where username = #{username} and password = #{password}")
    User login(String username, String password);

    @Select("select * from user where username = #{username} and password = #{password}")
    User getByUsernameAndPassword(User user);

    @Select("select * from user where username = #{username}")
    User getByUsername(String username);
}
