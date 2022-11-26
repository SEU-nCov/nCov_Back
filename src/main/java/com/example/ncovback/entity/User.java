package com.example.ncovback.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer user_id;
    private String phone;
    private String password;
    private String user_name;
    private String user_identify;
    private Integer user_signcolor;
    private Date sign_timeleft;
    private String picture_url;
    private String town_id;
    private String town_name;
    private String detail_location;
    private String area_name;
}
