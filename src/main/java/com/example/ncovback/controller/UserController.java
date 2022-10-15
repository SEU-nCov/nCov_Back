package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.User;
import com.example.ncovback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/userLogin")
    public R login(@RequestBody User user){
        User loginuser=userService.login(user);
        R r=new R();
        if(loginuser!=null){
            r.setCode(200);
            r.setMsg("LoginSuccess");
            r.setData(loginuser);
        }
        else {
            r.setCode(201);
            r.setMsg("LoginError");
        }
        return r;
    }
    @PostMapping("/userRegister")
    public R register(@RequestBody User user){
        int res=userService.register(user);
        R r=new R();
        if(res!=0){
            r.setCode(200);
            r.setMsg("registersuccess");
        }
        else {
            r.setCode(201);
            r.setMsg("registererror");
        }
        return r;
    }
}
