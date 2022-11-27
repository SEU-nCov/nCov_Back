package com.example.ncovback.mapper;

import com.example.ncovback.entity.Consult;
import com.example.ncovback.entity.Status_value;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsultMapper {
    Consult getUserInfo(Consult consult);

    Integer addUserconsult(Consult temp);

    List<Consult> getCityConsult(Consult consult);

    void handleConsult(Consult consult);

    Consult getUserid(Consult consult);

    Integer addConsultResultMessage(Consult temp);

    List<Status_value> getConsultStatusvalue(Consult consult);
}
