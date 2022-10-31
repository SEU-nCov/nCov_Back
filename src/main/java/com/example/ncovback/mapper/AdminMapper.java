package com.example.ncovback.mapper;

import com.example.ncovback.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    Admin Login(Admin admin);
}
