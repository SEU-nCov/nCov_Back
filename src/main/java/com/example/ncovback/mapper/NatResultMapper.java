package com.example.ncovback.mapper;

import com.example.ncovback.entity.NatResult;
import com.example.ncovback.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NatResultMapper {
    List<NatResult> getNatResultbyid(User user);


    void sampleInput(NatResult tempres);

    Integer natResultInput(NatResult natResult);
}
