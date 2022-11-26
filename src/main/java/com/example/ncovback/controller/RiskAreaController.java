package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.RiskArea;
import com.example.ncovback.mapper.RiskAreaMapper;
import com.example.ncovback.service.RiskAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RiskAreaController {
    @Autowired
    private RiskAreaService riskAreaService;
    @GetMapping ("/admin/getAllRiskArea")
    public R getAllRiskArea(){
        R r=new R();
        List<RiskArea> riskAreas=riskAreaService.getAllRiskArea();
        if(riskAreas.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(riskAreas);
        }else {
            r.setData(201);
            r.setMsg("当前区域为常态化区域");
        }
        return r;
    }
    @PostMapping("/admin/getAllRiskAreabyAreaCode")
    public R getAllRiskAreabyAreaCode(@RequestBody RiskArea riskArea){
        R r=new R();
        List<RiskArea> riskAreas=riskAreaService.getAllRiskAreabyAreaCode(riskArea);
        if(riskAreas.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(riskAreas);
        }else {
            r.setData(201);
            r.setMsg("当前区域为常态化区域");
        }
        return r;
    }
    @PostMapping("/admin/editRiskArea")
    public R editRiskArea(@RequestBody RiskArea riskArea){
        R r=new R();
        Integer res=riskAreaService.editRiskArea(riskArea);
        if(res!=0){
            r.setCode(200);
            r.setMsg("修改成功");
            r.setData(res);
        }else {
            r.setData(201);
            r.setMsg("修改失败");
        }
        return r;
    }
    @PostMapping("/admin/addRiskArea")
    public R addRiskArea(@RequestBody RiskArea riskArea){
        R r=new R();
        Integer res=riskAreaService.addRiskArea(riskArea);
        if(res!=0){
            r.setCode(200);
            r.setMsg("添加成功");
            r.setData(res);
        }else {
            r.setData(201);
            r.setMsg("添加失败");
        }
        return r;
    }
    @PostMapping("/admin/deleteRiskArea")
    public R deleteRiskArea(@RequestBody RiskArea riskArea){
        R r=new R();
        Integer res=riskAreaService.deleteRiskArea(riskArea);
        if(res!=0){
            r.setCode(200);
            r.setMsg("删除成功");
            r.setData(res);
        }else {
            r.setData(201);
            r.setMsg("删除失败");
        }
        return r;
    }
}
