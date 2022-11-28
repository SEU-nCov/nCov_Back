package com.example.ncovback.mapper;

import com.example.ncovback.entity.TestPoint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestPointMapper {
    List<TestPoint> getAllTestPoint();

    List<TestPoint> getTestPointbycity(TestPoint testPoint);

    Integer addTestPointbycity(TestPoint testPoint);

    Integer editTestPointbycity(TestPoint testPoint);

    List<TestPoint> getTestPointbyarea(TestPoint testPoint);
}
