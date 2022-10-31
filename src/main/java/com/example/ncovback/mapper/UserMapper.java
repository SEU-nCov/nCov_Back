package com.example.ncovback.mapper;

import com.example.ncovback.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface UserMapper {
    User login(User user);

    Integer register(User user) throws Exception;

    Integer ifExist(User user);
}
