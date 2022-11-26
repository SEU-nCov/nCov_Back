package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.TravelPolicy;
import com.example.ncovback.service.TravelPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TravelPolivyController {
    @Autowired
    private TravelPolicyService travelPolicyService;
    @PostMapping("/getTravelPolicy")
    public R getTravelPolicy(@RequestBody TravelPolicy travelPolicy){
        R r =new R();
        TravelPolicy result=travelPolicyService.getTravelPolicy(travelPolicy);
        if(result==null){
            r.setCode(201);
            r.setMsg("暂时未收录");
        }else {
            r.setCode(200);
            r.setMsg("查询成功");
            r.setData(result);
        }
        return r;
    }
    @PostMapping("/getSingleCityPolicy")
    public R getSingleCityPolicy(@RequestBody TravelPolicy travelPolicy){
        R r =new R();
        TravelPolicy result=travelPolicyService.getSingleCityPolicy(travelPolicy);
        if(result==null){
            r.setCode(201);
            r.setMsg("暂时未收录");
        }else {
            r.setCode(200);
            r.setMsg("查询成功");
            r.setData(result);
        }
        return r;
    }
}
