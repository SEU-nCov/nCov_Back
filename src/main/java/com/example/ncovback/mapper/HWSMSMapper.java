package com.example.ncovback.mapper;

import com.example.ncovback.entity.Message;
import com.example.ncovback.entity.Sms;
import com.example.ncovback.entity.Town;
import com.example.ncovback.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface HWSMSMapper {
    Integer TopicExist(Sms sms);

    void InsertTopic(Sms sms);

    String getTopicurn(Sms sms);

    List<String> getTopiclist(Message message);

    List<String> getTopiclistbyArea(Integer area_code);


    List<Integer> getUserListbyarea(String area_code);

    void addCovAllTestMessage(Integer user_id);
}
