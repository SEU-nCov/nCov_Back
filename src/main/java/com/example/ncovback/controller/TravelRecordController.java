package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.PosPeopleTravel;
import com.example.ncovback.entity.TravelRecord;
import com.example.ncovback.service.TravelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class TravelRecordController {
    @Autowired
    private TravelRecordService travelrecordservice;
    @PostMapping("/addTravelRecord")
    public R addTravelRecordby(@RequestBody TravelRecord travelRecord) {
        R r = new R();
        Integer res = travelrecordservice.addTravelRecord(travelRecord);
        if (res != 0) {
            r.setCode(200);
            r.setMsg("行程添加成功");
            r.setData(res);
        } else {
            r.setCode(201);
            r.setMsg("添加失败");
        }
        return r;
    }
    @PostMapping("/getTravelRecordbyuid")
    public R getTravelRecordbyuid(@RequestBody TravelRecord travelRecord) {
        R r = new R();
        List<String> res = travelrecordservice.getTravelRecordbyuid(travelRecord);
        if (res.size()>0) {
            r.setCode(200);
            r.setMsg("行程获取成功");
            r.setData(res);
        } else {
            r.setCode(201);
            r.setMsg("获取失败或行程未空");
        }
        return r;
    }
    @PostMapping("/admin/getPositivePeopleTravel")
    public R getPositivePeopleTravel(@RequestBody Map<String,String> data) {
        R r = new R();
        String city_code=data.get("city_code");
        List<TravelRecord> res = travelrecordservice.getPositivePeopleTravel(city_code);
        if (res.size()>0) {
            r.setCode(200);
            r.setMsg("行程获取成功");
            r.setData(res);
        } else {
            r.setCode(201);
            r.setMsg("获取失败或行程未空");
        }
        return r;
    }
    @PostMapping("/admin/getTotalTodayConfirm")
    public R getTotalTodayConfirm(@RequestBody Map<String,String> data) {
        R r = new R();
        String city_code=data.get("city_code");
        PosPeopleTravel res = travelrecordservice.getTotalTodayConfirm(city_code);
        if (res!=null) {
            r.setCode(200);
            r.setMsg("获取成功");
            r.setData(res);
        } else {
            r.setCode(201);
            r.setMsg("获取失败");
        }
        return r;
    }
}
