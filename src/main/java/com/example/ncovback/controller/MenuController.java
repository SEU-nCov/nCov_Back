package com.example.ncovback.controller;

import com.example.ncovback.common.AdminR;
import com.example.ncovback.entity.Admin;
import com.example.ncovback.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    @PostMapping("/getMenu")
    public AdminR getMenu(@RequestBody Admin admin){
        return menuService.getMenu(admin);
    }

}
