package com.example.ncovback.entity;

import lombok.Data;

@Data
public class VacPoint {
    private Integer vac_pointid;
    private String vac_pointname;
    private Integer city_code;
    private Double latitude;
    private Double longitude;
    private String location;
    private String open_time;
    private String vac_pointphone;
    private String vac_kind;
    private String city_name;
    private String vac_extraInfo;
}
