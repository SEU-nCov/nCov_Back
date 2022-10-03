package com.example.ncovback.service;

import com.example.ncovback.entity.User;
import com.example.ncovback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User loginbyphone(User user) {
        return userMapper.loginbyphone(user);
    }
}
