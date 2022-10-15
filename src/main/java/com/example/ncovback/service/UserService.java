package com.example.ncovback.service;

import com.example.ncovback.entity.User;
import com.example.ncovback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User login(User user) {
        return userMapper.login(user);
    }

    public Integer register(User user) {
        int res=0;
        try {
            res=userMapper.register(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
