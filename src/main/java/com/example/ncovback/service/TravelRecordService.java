package com.example.ncovback.service;

import com.example.ncovback.entity.PosPeopleTravel;
import com.example.ncovback.entity.TravelRecord;
import com.example.ncovback.mapper.TravelRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<TravelRecord> getPositivePeopleTravel(String city_code) {
        List<Integer> user_list=travelrecordmapper.getPosPeople(city_code);
        List<TravelRecord> list= new ArrayList<>();
        for(Integer index:user_list){
            list.addAll(travelrecordmapper.getTravelRecordUser(index));//每个人去过的城市
        }
        return list;
    }

    public PosPeopleTravel getTotalTodayConfirm(String city_code) {
        PosPeopleTravel temp=new PosPeopleTravel();
        temp.setTotalConfirm(travelrecordmapper.getTotalConfirm(city_code));
        temp.setTodayConfirm(travelrecordmapper.getTodayConfirm(city_code));
        return temp;
    }
}
