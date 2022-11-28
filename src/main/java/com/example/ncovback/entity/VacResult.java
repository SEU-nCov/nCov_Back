package com.example.ncovback.entity;

import lombok.Data;

import java.util.Date;

@Data
public class VacResult {
    private Integer v_id;
    private Integer user_id;
    private String user_name;
    private String user_identify;
    private Integer vac_pointid;
    private Date vac_time;
    private String vac_name;
    private String vac_pointname;
    private String address;
    private Integer dose;
    private String city_code;
}
