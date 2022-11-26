package com.example.ncovback.mapper;

import com.example.ncovback.entity.TravelPolicy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TravelPolicyMapper {
    TravelPolicy getTravelPolicy(TravelPolicy travelPolicy);

    TravelPolicy getSingleCityPolicy(TravelPolicy travelPolicy);

    Integer editCovPolicy(TravelPolicy travelPolicy);
}
