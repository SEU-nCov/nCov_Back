package com.example.ncovback.mapper;

import com.example.ncovback.entity.NatPoint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NatPointMapper {
    List<NatPoint> getNatPointbycity(NatPoint natPoint);
}