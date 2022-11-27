package com.example.ncovback.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Appeal {
    private Integer appeal_id;
    private String city_code;
    private Integer user_id;
    private String user_name;
    private String user_identify;
    private String user_phone;
    private String user_location;
    private Integer user_signcolor;
    private String appeal_reason;
    private Date appeal_time;
    private Integer appeal_status;
}
