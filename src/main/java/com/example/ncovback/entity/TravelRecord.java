package com.example.ncovback.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TravelRecord {
    private Integer t_id;
    private Integer user_id;
    private String user_name;
    private String area_code;
    private String street_id;
    private Date date;
    private String city_code;
    private String city_name;
    private String city_latitude;
    private String city_longitude;
}
