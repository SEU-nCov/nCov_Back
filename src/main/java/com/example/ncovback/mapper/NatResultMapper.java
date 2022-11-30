package com.example.ncovback.mapper;

import com.example.ncovback.entity.NatResult;
import com.example.ncovback.entity.NatStatistics;
import com.example.ncovback.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NatResultMapper {
    List<NatResult> getNatResultbyid(User user);


    void sampleInput(NatResult tempres);

    Integer natResultInput(NatResult natResult);

    List<NatStatistics> getTenDayNatnumber(String city_code);

    Integer getNatStatisticsCollected(String city_code);

    Integer getNatStatisticsTested(String city_code);

    Integer getNatStatisticsNegative(String city_code);

    NatStatistics getNatnumOfArea(NatStatistics natStatistics);

    List<NatStatistics> getNatCitybyCode(String city_code);

    NatStatistics getTodayNatnumOfArea(NatStatistics area);

    void setRedSignbyTube(String tube_id);

    List<NatResult> getAllNatResult(String city_code);
}
