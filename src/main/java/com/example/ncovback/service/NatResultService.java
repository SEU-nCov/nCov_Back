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
}
