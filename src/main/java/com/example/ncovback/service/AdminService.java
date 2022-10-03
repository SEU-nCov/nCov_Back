package com.example.ncovback.service;

import com.example.ncovback.entity.Admin;
import com.example.ncovback.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public void adminLogin(Admin admin) {
        adminMapper.adminLogin(admin);
    }
}
