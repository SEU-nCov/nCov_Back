package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.NatResult;
import com.example.ncovback.entity.User;
import com.example.ncovback.service.NatResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class NatResultController {
    @Autowired
    private NatResultService natResultService;
    @PostMapping("/getNatResultbyid")
    public R getNatResultbyid(@RequestBody User user){
        R r=new R();
        List<NatResult> results=natResultService.getNatResultbyid(user);
        if(results.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(results);
        }else {
            r.setCode(201);
            r.setMsg("暂未参加核酸检测");
        }
        return r;
    }
}
