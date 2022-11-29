package com.example.ncovback.service;

import com.example.ncovback.entity.TestPoint;
import com.example.ncovback.mapper.TestPointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestPointService {
    @Autowired
    private TestPointMapper testPointMapper;
    public List<TestPoint> getAllTestPoint() {
        return testPointMapper.getAllTestPoint();
    }

    public List<TestPoint> getTestPointbycity(TestPoint testPoint) {
        return testPointMapper.getTestPointbycity(testPoint);
    }

    public Integer addTestPointbycity(TestPoint testPoint) {
        return  testPointMapper.addTestPointbycity(testPoint);
    }

    public Integer editTestPointbycity(TestPoint testPoint) {
        return testPointMapper.editTestPointbycity(testPoint);
    }

    public List<TestPoint> getTestPointbyarea(TestPoint testPoint) {
        return testPointMapper.getTestPointbyarea(testPoint);
    }

    public Integer deleteTestPointbycity(TestPoint testPoint) {
        return testPointMapper.deleteTestPointbycity(testPoint);
    }
}
