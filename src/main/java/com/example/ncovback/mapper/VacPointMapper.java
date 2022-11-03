package com.example.ncovback.mapper;

import com.example.ncovback.entity.VacPoint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VacPointMapper {
    List<VacPoint> getVacPointbycity(VacPoint vacPoint);
}
