package com.example.ncovback.entity;

import lombok.Data;

import java.util.List;

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
    private String nat_account;
    private String nat_password;
    private String area_code;
}
