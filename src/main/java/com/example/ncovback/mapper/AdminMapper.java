package com.example.ncovback.mapper;

import com.example.ncovback.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("select * from admin_account where manager_id=#{manager_id} and password=#{password}")
    Integer adminLogin(Admin admin);
}
