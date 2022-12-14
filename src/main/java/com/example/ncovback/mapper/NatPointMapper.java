package com.example.ncovback.mapper;

import com.example.ncovback.entity.NatPoint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NatPointMapper {
    List<NatPoint> getNatPointbycity(NatPoint natPoint);

    Integer addTest(NatPoint natPoint);

    Integer editTest(NatPoint natPoint);

    Integer deleteTest(NatPoint natPoint);

    List<NatPoint> getTest();

    NatPoint natLogin(NatPoint natPoint);

    List<NatPoint> getPointsbyname(NatPoint natPoint);

    List<NatPoint> getPointsbyarea(NatPoint natPoint);

    List<NatPoint> getPointsbyThreeVariable(NatPoint natPoint);
}
