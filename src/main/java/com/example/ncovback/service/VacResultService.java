package com.example.ncovback.service;

import com.example.ncovback.entity.User;
import com.example.ncovback.entity.VacResult;
import com.example.ncovback.entity.VaccinedCity;
import com.example.ncovback.mapper.VacResultMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
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

    public List<String> getCovVacpointName(VacResult vacResult) {
        return vacResultMapper.getCovVacpointName(vacResult);
    }

    public List<VacResult> searchVaccine(VacResult vacResult) {
        return vacResultMapper.searchVaccine(vacResult);
    }

    public List<VaccinedCity> getvaccineAreaRanking(Integer city_code) {
        List<VaccinedCity> area_list=vacResultMapper.getVacCitybyCode(city_code);
        for(VaccinedCity area:area_list){
            VaccinedCity temp=vacResultMapper.getvaccineAreaRanking(area);
            area.setVaccined_value(temp.getVaccined_value());
        }
        Collections.sort(area_list);
        return area_list;
    }
}
