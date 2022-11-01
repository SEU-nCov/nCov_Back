package com.example.ncovback.entity;

import lombok.Data;

import java.util.Date;

@Data
public class VacResult {
    private Integer v_id;
    private Integer user_id;
    private Integer vac_pointid;
    private Date vac_time;
    private String vac_name;
    private String vac_pointname;
}
