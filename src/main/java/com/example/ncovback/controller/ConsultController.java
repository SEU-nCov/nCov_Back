package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.Appeal;
import com.example.ncovback.entity.Consult;
import com.example.ncovback.entity.Status_value;
import com.example.ncovback.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ConsultController {
    @Autowired
    private ConsultService consultService;
    @PostMapping("/addUserconsult")
    public R addUserconsult(@RequestBody Consult consult){
        R r=new R();
        Integer res=consultService.addUserconsult(consult);
        if(res!=0){
            r.setCode(200);
            r.setMsg("咨询添加成功");
            r.setData(res);
        }else {
            r.setCode(201);
            r.setMsg("error");
        }
        return r;
    }
    @PostMapping("/admin/getCityConsult")
    public R getCityConsult(@RequestBody Consult consult){
        R r=new R();
        List<Consult> list =consultService.getCityConsult(consult);
        if(list.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(list);
        }else {
            r.setCode(201);
            r.setMsg("没有信息");
        }
        return r;
    }

    @PostMapping("/admin/getConsultStatusvalue")
    public R getConsultStatusvalue(@RequestBody Consult consult){
        R r=new R();
        List<Status_value> list =consultService.getConsultStatusvalue(consult);
        if(list.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(list);
        }else {
            r.setCode(201);
            r.setMsg("没有申诉信息");
        }
        return r;
    }

    @PostMapping("/admin/handleConsult")
    public R handleConsult(@RequestBody Consult consult){
        R r=new R();
        Integer res=consultService.handleConsult(consult);
        if(res!=0){
            r.setCode(200);
            r.setMsg("健康咨询处理成功");
            r.setData(res);
        }else {
            r.setCode(201);
            r.setMsg("error");
        }
        return r;
    }
}
