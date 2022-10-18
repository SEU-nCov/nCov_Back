package com.example.ncovback.mapper;

import com.example.ncovback.entity.Sms;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HWSMSMapper {
    @Select("select count(*) from tb_hwsms where phone=#{phone};")
    Integer TopicExist(Sms sms);

    @Insert("insert into tb_hwsms values(#{phone},#{topicurn});")
    void InsertTopic(Sms sms);

    @Select("select topicurn from tb_hwsms where phone=#{phone};")
    String getTopicurn(Sms sms);
}
