package com.example.ncovback.service;

import com.example.ncovback.entity.Town;
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

    public List<VacPoint> getvaccinedPoints(VacPoint vacPoint) {
        return vacPointMapper.getvaccinedPoints(vacPoint);
    }

    public Integer editvaccinedPoints(VacPoint vacPoint) {
        return vacPointMapper.editvaccinedPoints(vacPoint);
    }

    public List<Town> getAreabyCityCode(String city_code) {
        return vacPointMapper.getAreabyCityCode(city_code);
    }
}
