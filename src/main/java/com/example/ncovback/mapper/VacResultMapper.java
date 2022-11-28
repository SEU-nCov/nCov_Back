package com.example.ncovback.mapper;

import com.example.ncovback.entity.User;
import com.example.ncovback.entity.VacResult;
import com.example.ncovback.entity.VaccinedCity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VacResultMapper {
    List<VacResult> getVacResultbyid(User user);

    List<String> getCovVacpeopleName();

    List<String> getCovVacpointName(VacResult vacResult);

    List<VacResult> searchVaccine(VacResult vacResult);

    List<VaccinedCity> getvaccineAreaRanking(Integer city_code);
}
