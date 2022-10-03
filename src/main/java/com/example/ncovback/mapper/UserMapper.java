package com.example.ncovback.mapper;

import com.example.ncovback.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from tb_user where phone=#{phone} and password=#{password};")
    User loginbyphone(User user);
}
