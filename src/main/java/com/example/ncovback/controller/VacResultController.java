package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.User;
import com.example.ncovback.entity.VacResult;
import com.example.ncovback.service.VacResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class VacResultController {
    @Autowired
    private VacResultService vacResultService;
    @PostMapping("/getVacResultbyid")
    public R getVacResultbyid(@RequestBody User user){
        R r=new R();
        List<VacResult> results=vacResultService.getVacResultbyid(user);
        if(results.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(results);
        }else {
            r.setCode(201);
            r.setMsg("获取失败");
        }
        return r;
    }
}
