package com.example.ncovback.entity;

import lombok.Data;

@Data
public class NatPoint {
    private Integer nat_pointid;
    private String nat_pointname;
    private Integer city_code;
    private Double latitude;
    private Double longitude;
    private String location;
    private String open_time;
    private String nat_pointphone;
    private String nat_unusualcolor;
    private String city_name;
    private Integer nat_type;
    private Integer nat_turnaroundTime;
    private Integer nat_reservation;
    private String nat_extraInfo;
}
