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
    @PostMapping("/loginbyphone")
    public R loginbyphone(@RequestBody User user){
        User loginuser=userService.loginbyphone(user);
        R r=new R();
        if(loginuser!=null){
            r.setCode(200);
            r.setMsg("loginphonesuccess");
            r.setData(loginuser);
        }
        else {
            r.setCode(201);
            r.setMsg("loginerror");
        }
        return r;
    }
}
