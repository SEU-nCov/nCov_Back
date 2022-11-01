package com.example.ncovback.mapper;

import com.example.ncovback.entity.User;
import com.example.ncovback.entity.VacResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VacResultMapper {
    List<VacResult> getVacResultbyid(User user);
}
