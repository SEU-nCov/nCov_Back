package com.example.ncovback.service;

import com.example.ncovback.entity.NatResult;
import com.example.ncovback.entity.User;
import com.example.ncovback.mapper.NatResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return natResultMapper.natResultInput(natResult);
    }
}
