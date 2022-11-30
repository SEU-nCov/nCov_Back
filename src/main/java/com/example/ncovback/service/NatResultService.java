package com.example.ncovback.service;

import com.example.ncovback.entity.NatResult;
import com.example.ncovback.entity.NatStatistics;
import com.example.ncovback.entity.User;
import com.example.ncovback.entity.VaccinedCity;
import com.example.ncovback.mapper.NatResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class NatResultService {
    @Autowired
    private NatResultMapper natResultMapper;
    public List<NatResult> getNatResultbyid(User user) {
        return natResultMapper.getNatResultbyid(user);
    }

    public Integer sampleInput(NatResult natResult) {
        NatResult tempres=new NatResult();
        tempres.setNat_pointid(natResult.getNat_pointid());
        tempres.setTube_id(natResult.getTube_id());
        List<Integer> user_list=natResult.getUser_list();
        for (Integer index : user_list) {
            tempres.setUser_id(index);
            natResultMapper.sampleInput(tempres);
        }
        return 1;
    }

    public Integer natResultInput(NatResult natResult) {
        if (!natResult.getNat_result().equals("阴性")) {
            natResultMapper.setRedSignbyTube(natResult.getTube_id());
        }
        return natResultMapper.natResultInput(natResult);
    }

    public List<NatStatistics> getTenDayNatnumber(String city_code) {
        return natResultMapper.getTenDayNatnumber(city_code);
    }

    public Integer getNatStatisticsCollected(String city_code) {
        return natResultMapper.getNatStatisticsCollected(city_code);
    }

    public Integer getNatStatisticsTested(String city_code) {
        return natResultMapper.getNatStatisticsTested(city_code);
    }

    public Integer getNatStatisticsNegative(String city_code) {
        return natResultMapper.getNatStatisticsNegative(city_code);
    }

    public List<NatStatistics> getNatnumOfArea(String city_code) {
        List<NatStatistics> area_list=natResultMapper.getNatCitybyCode(city_code);
        for(NatStatistics area:area_list){
            NatStatistics temp=natResultMapper.getNatnumOfArea(area);
            area.setT_areanat(temp.getT_areanat());
        }
        Collections.sort(area_list);
        return area_list;
    }

    public List<NatStatistics> getTodayNatnumOfArea(String city_code) {
        List<NatStatistics> area_list=natResultMapper.getNatCitybyCode(city_code);
        for(NatStatistics area:area_list){
            NatStatistics temp=natResultMapper.getTodayNatnumOfArea(area);
            area.setT_areanat(temp.getT_areanat());
        }
        Collections.sort(area_list);
        return area_list;
    }

    public List<NatResult> getAllNatResult(String city_code) {
        return natResultMapper.getAllNatResult(city_code);
    }
}
