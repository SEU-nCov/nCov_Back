package com.example.ncovback.service;

import com.example.ncovback.entity.User;
import com.example.ncovback.entity.VacResult;
import com.example.ncovback.mapper.VacResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacResultService {
    @Autowired
    private VacResultMapper vacResultMapper;
    public List<VacResult> getVacResultbyid(User user) {
        return vacResultMapper.getVacResultbyid(user);
    }
}
