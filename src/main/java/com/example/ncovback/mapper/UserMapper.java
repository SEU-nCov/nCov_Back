package com.example.ncovback.mapper;

import com.example.ncovback.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface UserMapper {
    @Select("select * from tb_user where phone=#{phone} and password=#{password};")
    User login(User user);

    @SelectKey(statement = "select max(user_id)+1 from tb_user", before = true, resultType = Integer.class, keyProperty = "user_id")
    @Insert("insert into tb_user (user_id,phone,password,user_name,user_identify,code_color) values(#{user_id},#{phone},#{password},#{user_name},#{user_identify},0 ) ")
    Integer register(User user) throws Exception;
}
