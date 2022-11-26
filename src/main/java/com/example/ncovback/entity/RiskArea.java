package com.example.ncovback.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RiskArea {
    private Integer risk_id;
    private String area_code;
    private String risk_address;
    private Date update_time;
    private Integer risk_level;
}
