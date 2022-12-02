package com.example.ncovback.mapper;

import com.example.ncovback.entity.PosPeopleTravel;
import com.example.ncovback.entity.TravelRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TravelRecordMapper {
    Integer addTravelRecord(TravelRecord travelRecord);

    List<String> getTravelRecordbyuid(TravelRecord travelRecord);

    List<Integer> getPosPeople(String city_code);

    List<TravelRecord> getTravelRecordUser(Integer index);

    String getTotalConfirm(String city_code);

    String getTodayConfirm(String city_code);
}
