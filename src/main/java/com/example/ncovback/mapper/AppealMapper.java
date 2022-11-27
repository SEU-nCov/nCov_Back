package com.example.ncovback.mapper;

import com.example.ncovback.entity.Appeal;
import com.example.ncovback.entity.Status_value;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppealMapper {
    Appeal getUserInfo(Appeal appeal);

    Integer addUserappeal(Appeal temp);

    List<Appeal> getCityAppeal(Appeal appeal);

    void handleAppeal(Appeal appeal);

    Integer addAppealResultMessage(Integer temp);

    Integer getUserid(Appeal appeal);

    List<Status_value> getAppealStatusvalue(Appeal appeal);
}
