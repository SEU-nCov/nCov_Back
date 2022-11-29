package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.NatPoint;
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
    @PostMapping("/admin/get/TestPoint")
    public R getTestPointbycity(@RequestBody TestPoint testPoint){
        R r=new R();
        List<TestPoint> result=testPointService.getTestPointbycity(testPoint);
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
    @PostMapping("/admin/get/AreaTestPoint")
    public R getTestPointbyarea(@RequestBody TestPoint testPoint){
        R r=new R();
        List<TestPoint> result=testPointService.getTestPointbyarea(testPoint);
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
    @PostMapping("/admin/add/TestPoint")
    public R addTestPointbycity(@RequestBody TestPoint testPoint){
        R r=new R();
        Integer result=testPointService.addTestPointbycity(testPoint);
        if(result!=0){
            r.setCode(200);
            r.setMsg("添加成功");
            r.setData(result);
        }else {
            r.setCode(201);
            r.setMsg("error");
        }
        return r;
    }
    @PostMapping("/admin/edit/TestPoint")
    public R editTestPointbycity(@RequestBody TestPoint testPoint){
        R r=new R();
        Integer result=testPointService.editTestPointbycity(testPoint);
        if(result!=0){
            r.setCode(200);
            r.setMsg("修改成功");
            r.setData(result);
        }else {
            r.setCode(201);
            r.setMsg("error");
        }
        return r;
    }

    @PostMapping("/admin/delete/TestPoint")
    public R deleteTestPointbycity(@RequestBody TestPoint testPoint){
        R r=new R();
        Integer result=testPointService.deleteTestPointbycity(testPoint);
        if(result!=0){
            r.setCode(200);
            r.setMsg("删除成功");
            r.setData(result);
        }else {
            r.setCode(201);
            r.setMsg("error");
        }
        return r;
    }
}
