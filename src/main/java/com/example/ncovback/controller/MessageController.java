package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.Message;
import com.example.ncovback.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/getAllMessage")
    public R getAllMessage(@RequestBody Message message){
        List<Message> list=messageService.getAllMessage(message);
        R r=new R();
        if(list.size()>0){
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(list);
        }
        else {
            r.setCode(201);
            r.setMsg("获取失败");
        }
        return r;
    }


}
