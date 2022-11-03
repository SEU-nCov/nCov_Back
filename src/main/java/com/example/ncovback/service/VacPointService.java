package com.example.ncovback.service;

import com.example.ncovback.entity.VacPoint;
import com.example.ncovback.mapper.VacPointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacPointService {
    @Autowired
    private VacPointMapper vacPointMapper;
    public List<VacPoint> getVacPointbycity(VacPoint vacPoint) {
        return vacPointMapper.getVacPointbycity(vacPoint);
    }
}
