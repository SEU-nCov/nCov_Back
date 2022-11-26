package com.example.ncovback.mapper;

import com.example.ncovback.entity.RiskArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RiskAreaMapper {
    List<RiskArea> getAllRiskArea();

    List<RiskArea> getAllRiskAreabyAreaCode(RiskArea riskArea);

    Integer editRiskArea(RiskArea riskArea);

    Integer addRiskArea(RiskArea riskArea);

    Integer deleteRiskArea(RiskArea riskArea);
}
