package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.TestPoint;
import com.example.ncovback.service.TestPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TestPointController {
    @Autowired
    private TestPointService testPointService;

    @PostMapping("/getAllTestPoint")
    public R getAllTestPoint(){
        R r=new R();
        List<TestPoint> list=testPointService.getAllTestPoint();
        r.setCode(200);
        r.setData(list);
        r.setMsg("获取成功");
        return r;
    }
}
