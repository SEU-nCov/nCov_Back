package com.example.ncovback.service;

import com.example.ncovback.entity.Appeal;
import com.example.ncovback.entity.Consult;
import com.example.ncovback.entity.Status_value;
import com.example.ncovback.mapper.ConsultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultService {
    @Autowired
    private ConsultMapper consultMapper;

    public Integer addUserconsult(Consult consult) {
        Consult temp=consultMapper.getUserInfo(consult);
        temp.setConsult_content(consult.getConsult_content());
        return consultMapper.addUserconsult(temp);
    }

    public List<Consult> getCityConsult(Consult consult) {
        return consultMapper.getCityConsult(consult);
    }

    public Integer handleConsult(Consult consult) {
        consultMapper.handleConsult(consult);
        Consult temp=consultMapper.getUserid(consult);
        temp.setConsult_answer(consult.getConsult_answer());
        return consultMapper.addConsultResultMessage(temp);
    }

    public List<Status_value> getConsultStatusvalue(Consult consult) {
        return consultMapper.getConsultStatusvalue(consult);
    }
}
