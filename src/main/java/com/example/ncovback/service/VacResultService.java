package com.example.ncovback.service;

import com.example.ncovback.entity.User;
import com.example.ncovback.entity.VacResult;
import com.example.ncovback.entity.VaccinedCity;
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

    public List<String> getCovVacpeopleName() {
        return vacResultMapper.getCovVacpeopleName();
    }

    public List<String> getCovVacpointName() {
        return vacResultMapper.getCovVacpointName();
    }

    public List<VacResult> searchVaccine(VacResult vacResult) {
        return vacResultMapper.searchVaccine(vacResult);
    }

    public List<VaccinedCity> getvaccineAreaRanking(Integer city_code) {
        return vacResultMapper.getvaccineAreaRanking(city_code);
    }
}
