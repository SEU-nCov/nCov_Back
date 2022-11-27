package com.example.ncovback.service;

import com.example.ncovback.entity.Appeal;
import com.example.ncovback.entity.Status_value;
import com.example.ncovback.mapper.AppealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppealService {
    @Autowired
    private AppealMapper appealMapper;

    public Integer addUserappeal(Appeal appeal) {
        Appeal temp=appealMapper.getUserInfo(appeal);
        temp.setAppeal_reason(appeal.getAppeal_reason());
        return appealMapper.addUserappeal(temp);
    }

    public List<Appeal> getCityAppeal(Appeal appeal) {
        return appealMapper.getCityAppeal(appeal);
    }

    public Integer handleAppeal(Appeal appeal) {
        appealMapper.handleAppeal(appeal);
        Integer temp=appealMapper.getUserid(appeal);
        return appealMapper.addAppealResultMessage(temp);
    }

    public List<Status_value> getAppealStatusvalue(Appeal appeal) {
        return appealMapper.getAppealStatusvalue(appeal);
    }
}
