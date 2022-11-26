package com.example.ncovback.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ncovback.common.R;
import com.example.ncovback.entity.Town;
import com.example.ncovback.entity.User;
import com.example.ncovback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/userLogin")
    public R login(@RequestBody User user){
        User loginuser=userService.login(user);
        R r=new R();
        if(loginuser!=null){
            r.setCode(200);
            r.setMsg("LoginSuccess");
            r.setData(loginuser);
        }
        else {
            r.setCode(201);
            r.setMsg("LoginError");
        }
        return r;
    }
    @PostMapping("/userRegister")
    public R register(@RequestBody User user){
        int res=userService.ifExist(user);
        R r=new R();
        if(res!=0){
            r.setCode(201);
            r.setMsg("已存在该账号");
        }else {
            res = userService.register(user);
            if (res != 0) {
                r.setCode(200);
                r.setMsg("注册成功");
            } else {
                r.setCode(202);
                r.setMsg("注册失败");
            }
        }
        return r;
    }

    @PostMapping("/userChangePassword")
    public R changePassword(@RequestBody User user){
        R r=new R();
        int res=userService.changePassword(user);
        if(res!=0){
            r.setCode(200);
            r.setMsg("修改成功");
        }else{
            r.setCode(201);
            r.setMsg("修改失败");
        }
        return r;
    }
    @PostMapping("/getRelativebyid")
    public R getRelativebyid(@RequestBody User user){
        R r=new R();
        List<User> res=userService.getRelativebyid(user);
        if(res.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(res);
        }else{
            r.setCode(201);
            r.setMsg("该用户没有亲友");
        }
        return r;
    }

    @PostMapping("/addRelativebyid")
    public R addRelativebyid(@RequestBody User user){
        R r=new R();
        int res=userService.addRelativebyid(user);
        if(res!=0){
            r.setCode(200);
            r.setMsg("添加成功");
        }else{
            r.setCode(201);
            r.setMsg("添加失败");
        }
        return r;
    }
    @PostMapping("/uploadPicture")
    public R uploadPicture(@RequestBody User user){
        int res=userService.uploadPicture(user);
        R r=new R();
        if(res!=0){
            r.setCode(200);
            r.setMsg("success");
        }
        else {
            r.setCode(201);
            r.setMsg("error");
        }
        return r;
    }
    @PostMapping("/changeUserPhone")
    public R changeUserPhone(@RequestBody User user){
        int res=userService.changeUserPhone(user);
        R r=new R();
        if(res!=0){
            r.setCode(200);
            r.setMsg("success");
        }
        else {
            r.setCode(201);
            r.setMsg("error");
        }
        return r;
    }
    @PostMapping("/deleteRelative")
    public R deleteRelativebyid(@RequestBody Map<String,Integer> data){
        R r=new R();
        Integer user_id=data.get("user_id");
        Integer relative_id=data.get("relative_id");
        int res=userService.deleteRelativebyid(user_id,relative_id);
        if(res!=0){
            r.setCode(200);
            r.setMsg("删除成功");
        }else{
            r.setCode(201);
            r.setMsg("删除失败");
        }
        return r;
    }
    @PostMapping("/declareHealthCode")
    public R declareHealthCode(@RequestBody User user){
        R r=new R();
        String town_id=userService.getTownid(user);
        user.setTown_id(town_id);
        System.out.println(town_id);
        Integer res=userService.declareHealthCode(user);
        if(res!=0){
            r.setCode(200);
            r.setMsg("更新或申报成功");
            r.setData(res);
        }else {
            r.setCode(201);
            r.setMsg("Error");
        }
        return r;
    }
    @PostMapping("/getTownbyarea")
    public R getTownbyarea(@RequestBody Map<String,String> data){
        R r=new R();
        String area_name=data.get("area_name");
        List<Town> town_list=userService.getTownbyarea(area_name);
        if(town_list.size()!=0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(town_list);
        }
        else {
            r.setCode(201);
            r.setMsg("error");
        }
        return r;
    }
}
