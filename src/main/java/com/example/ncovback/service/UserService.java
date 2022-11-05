package com.example.ncovback.service;

import com.alibaba.fastjson.JSONObject;
import com.example.ncovback.entity.User;
import com.example.ncovback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Integer ifExist(User user){
        return userMapper.ifExist(user);
    }

    public Integer changePassword(User user) {
        return userMapper.changePassword(user);
    }

    public List<User> getRelativebyid(User user) {
        return userMapper.getRelativebyid(user);
    }

    public Integer addRelativebyid(User user) {
        int user_id=user.getUser_id();
        userMapper.addRelativebyid(user);
        int relative_id=user.getUser_id();
        return userMapper.addRelation(user_id,relative_id);
    }
    public Integer uploadPicture(User user) {
        return userMapper.uploadPicture(user);
    }

    public Integer changeUserPhone(User user) {
        return userMapper.changeUserPhone(user);
    }


    public Integer deleteRelativebyid(Integer user_id, Integer relative_id) {
        int res1=userMapper.deleteRelation(user_id,relative_id);
        int res2=userMapper.deleteRelAccount(relative_id);
        return res1;
    }
}
