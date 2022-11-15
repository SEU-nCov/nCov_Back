package com.example.ncovback.mapper;

import com.example.ncovback.entity.TravelRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TravelRecordMapper {
    Integer addTravelRecord(TravelRecord travelRecord);

    List<String> getTravelRecordbyuid(TravelRecord travelRecord);
}
