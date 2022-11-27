package com.example.ncovback.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Consult {
    private Integer consult_id;
    private String city_code;
    private Integer user_id;
    private String user_name;
    private String user_identify;
    private String user_phone;
    private String user_location;
    private String consult_content;
    private Date consult_time;
    private Integer consult_status;
    private String consult_answer;
}
