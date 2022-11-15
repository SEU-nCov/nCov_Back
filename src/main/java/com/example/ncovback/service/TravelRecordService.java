package com.example.ncovback.service;

import com.example.ncovback.entity.TravelRecord;
import com.example.ncovback.mapper.TravelRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelRecordService {
    @Autowired
    private TravelRecordMapper travelrecordmapper;
    public Integer addTravelRecord(TravelRecord travelRecord) {
        return travelrecordmapper.addTravelRecord(travelRecord);
    }

    public List<String> getTravelRecordbyuid(TravelRecord travelRecord) {
        return travelrecordmapper.getTravelRecordbyuid(travelRecord);
    }
}
