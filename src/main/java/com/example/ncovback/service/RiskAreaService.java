package com.example.ncovback.service;

import com.example.ncovback.entity.RiskArea;
import com.example.ncovback.mapper.RiskAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAreaService {
    @Autowired
    private RiskAreaMapper riskAreaMapper;

    public List<RiskArea> getAllRiskArea() {
        return riskAreaMapper.getAllRiskArea();
    }

    public List<RiskArea> getAllRiskAreabyAreaCode(RiskArea riskArea) {
        return riskAreaMapper.getAllRiskAreabyAreaCode(riskArea);
    }

    public Integer editRiskArea(RiskArea riskArea) {
        return riskAreaMapper.editRiskArea(riskArea);
    }

    public Integer addRiskArea(RiskArea riskArea) {
        return riskAreaMapper.addRiskArea(riskArea);
    }

    public Integer deleteRiskArea(RiskArea riskArea) {
        return riskAreaMapper.deleteRiskArea(riskArea);
    }
}
