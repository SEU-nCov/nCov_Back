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
}
