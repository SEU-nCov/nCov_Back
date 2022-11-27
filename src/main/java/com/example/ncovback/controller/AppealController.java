package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.Appeal;
import com.example.ncovback.entity.Status_value;
import com.example.ncovback.service.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AppealController {
    @Autowired
    private AppealService appealService;

    @PostMapping("/addUserappeal")
    public R addUserappeal(@RequestBody Appeal appeal){
        R r=new R();
        Integer res=appealService.addUserappeal(appeal);
        if(res!=0){
            r.setCode(200);
            r.setMsg("申诉添加成功");
            r.setData(res);
        }else {
            r.setCode(201);
            r.setMsg("error");
        }
        return r;
    }
    @PostMapping("/admin/getCityAppeal")
    public R getCityAppeal(@RequestBody Appeal appeal){
        R r=new R();
        List<Appeal> appeals =appealService.getCityAppeal(appeal);
        if(appeals.size()!=0){
            r.setCode(200);
            r.setMsg("申诉获取成功");
            r.setData(appeals);
        }else {
            r.setCode(201);
            r.setMsg("没有申诉信息");
        }
        return r;
    }

    @PostMapping("/admin/getAppealStatusvalue")
    public R getAppealStatusvalue(@RequestBody Appeal appeal){
        R r=new R();
        List<Status_value> list =appealService.getAppealStatusvalue(appeal);
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

    @PostMapping("/admin/handleAppeal")
    public R handleAppeal(@RequestBody Appeal appeal){
        R r=new R();
        Integer res=appealService.handleAppeal(appeal);
        if(res!=0){
            r.setCode(200);
            r.setMsg("申诉处理成功");
            r.setData(res);
        }else {
            r.setCode(201);
            r.setMsg("error");
        }
        return r;
    }

}
