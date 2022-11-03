package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.NatPoint;
import com.example.ncovback.entity.VacPoint;
import com.example.ncovback.service.NatPointService;
import com.example.ncovback.service.VacPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class VacPointController {
    @Autowired
    private VacPointService vacPointService;
    @PostMapping("/getVacPointbycity")
    public R getVacPointbycity(@RequestBody VacPoint vacPoint){
        R r=new R();
        List<VacPoint> result=vacPointService.getVacPointbycity(vacPoint);
        if(result.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(result);
        }else {
            r.setCode(201);
            r.setMsg("暂时未收录该城市信息");
        }
        return r;
    }
}
