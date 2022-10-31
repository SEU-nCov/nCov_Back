package com.example.ncovback.mapper;

import com.example.ncovback.entity.Sms;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HWSMSMapper {
    Integer TopicExist(Sms sms);

    void InsertTopic(Sms sms);

    String getTopicurn(Sms sms);
}
