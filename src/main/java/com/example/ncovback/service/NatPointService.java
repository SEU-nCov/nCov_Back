package com.example.ncovback.service;

import com.example.ncovback.entity.NatPoint;
import com.example.ncovback.mapper.NatPointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatPointService {
    @Autowired
    private NatPointMapper natPointMapper;
    public List<NatPoint> getNatPointbycity(NatPoint natPoint) {
        return natPointMapper.getNatPointbycity(natPoint);
    }
}
