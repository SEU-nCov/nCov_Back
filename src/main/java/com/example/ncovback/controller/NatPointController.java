package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.NatPoint;
import com.example.ncovback.service.NatPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class NatPointController {
    @Autowired
    private NatPointService natPointService;
    @PostMapping("/getNatPointbycity")
    public R getNatPointbycity(@RequestBody NatPoint natPoint){
        R r=new R();
        List<NatPoint> result=natPointService.getNatPointbycity(natPoint);
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
