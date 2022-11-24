package com.example.ncovback.mapper;

import com.example.ncovback.entity.Message;
import com.example.ncovback.entity.NatResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    List<Message> getAllMessage(Message message);

    Integer addnatResultMessage(Message message);

    List<Integer> getUserbytubeid(Message message);
}
