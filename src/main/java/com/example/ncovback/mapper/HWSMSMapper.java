package com.example.ncovback.mapper;

import com.example.ncovback.entity.Message;
import com.example.ncovback.entity.Sms;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HWSMSMapper {
    Integer TopicExist(Sms sms);

    void InsertTopic(Sms sms);

    String getTopicurn(Sms sms);

    List<String> getTopiclist(Message message);
}
