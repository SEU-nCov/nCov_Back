package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.NatResult;
import com.example.ncovback.entity.User;
import com.example.ncovback.service.MessageService;
import com.example.ncovback.service.NatResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/sampleInput")
    public R sampleInput(@RequestBody NatResult natResult){
        R r=new R();
        Integer res=natResultService.sampleInput(natResult);
        if(res!=0){
            r.setCode(200);
            r.setMsg("添加成功");
            r.setData(res);
        }else {
            r.setCode(201);
            r.setMsg("添加失败，请重新提交");
        }
        return r;
    }
    @PostMapping("/natResultInput")
    public R natResultInput(@RequestBody NatResult natResult) {
        R r = new R();
        Integer res = natResultService.natResultInput(natResult);
        if (res != 0) {
            r.setCode(200);
            r.setMsg("录入结果成功");
            r.setData(res);
        } else {
            r.setCode(201);
            r.setMsg("录入失败，请重新提交");
        }
        return r;
    }

}
