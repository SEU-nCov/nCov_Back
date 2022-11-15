package com.example.ncovback.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TravelRecord {
    private Integer t_id;
    private Integer user_id;
    private String area_code;
    private String street_id;
    private Date date;
}
