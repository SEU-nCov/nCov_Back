package com.example.ncovback.service;

import com.example.ncovback.entity.TravelPolicy;
import com.example.ncovback.mapper.TravelPolicyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelPolicyService {
    @Autowired
    private TravelPolicyMapper travelPolicyMapper;
    public TravelPolicy getTravelPolicy(TravelPolicy travelPolicy) {
        return travelPolicyMapper.getTravelPolicy(travelPolicy);
    }
}
