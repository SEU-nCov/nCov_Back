package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.Admin;
import com.example.ncovback.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/admin/Login")
    public R adminLogin(@RequestBody Admin admin){
        return adminService.adminLogin(admin);
    }
}
