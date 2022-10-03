package com.example.ncovback.service;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.Admin;
import com.example.ncovback.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public R adminLogin(Admin admin) {
        R r=new R();
        Admin admin1= adminMapper.Login(admin);
        if(admin1!=null){
            r.setCode(200);
            r.setMsg("登陆成功");
            r.setData(admin1);
            return r;
        }
        else {
            r.setCode(201);
            r.setMsg("登陆失败");
            return r;
        }
    }
}
