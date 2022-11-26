package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.User;
import com.example.ncovback.entity.VacResult;
import com.example.ncovback.entity.VaccinedCity;
import com.example.ncovback.service.VacResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/admin/CovVaccine/get/peopleName")
    public R getCovVacpeopleName(){
        R r=new R();
        List<String> name_list=vacResultService.getCovVacpeopleName();
        if(name_list.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(name_list);
        }else {
            r.setCode(201);
            r.setMsg("获取失败");
        }
        return r;
    }

    @GetMapping("/admin/CovVaccine/get/pointName")
    public R getCovVacpointName(){
        R r=new R();
        List<String> name_list=vacResultService.getCovVacpointName();
        if(name_list.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(name_list);
        }else {
            r.setCode(201);
            r.setMsg("获取失败");
        }
        return r;
    }

    @PostMapping("/admin/CovVaccine/search")
    public R searchVaccine(@RequestBody VacResult vacResult){
        R r=new R();
        List<VacResult> vacResults=vacResultService.searchVaccine(vacResult);
        if(vacResults.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(vacResults);
        }else {
            r.setCode(201);
            r.setMsg("获取失败");
        }
        return r;
    }
    @PostMapping("/admin/CovVaccine/get/vaccineAreaRanking")
    public R getvaccineAreaRanking(@RequestBody Map<String,Integer> data){
        R r=new R();
        Integer city_code=data.get("city_code");
        List<VaccinedCity> list=vacResultService.getvaccineAreaRanking(city_code);
        if(list.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(list);
        }else {
            r.setCode(201);
            r.setMsg("获取失败");
        }
        return r;
    }

}
