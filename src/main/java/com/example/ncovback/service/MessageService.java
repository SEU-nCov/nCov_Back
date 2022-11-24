package com.example.ncovback.service;

import com.example.ncovback.entity.Message;
import com.example.ncovback.entity.NatResult;
import com.example.ncovback.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public List<Message> getAllMessage(Message message) {
        return messageMapper.getAllMessage(message);
    }

    public Integer addnatResultMessage(Message message) {
        List<Integer> user_list=messageMapper.getUserbytubeid(message);
        for(Integer index:user_list){
            message.setUser_id(index);
            messageMapper.addnatResultMessage(message);
        }
        return 1;
    }
}
