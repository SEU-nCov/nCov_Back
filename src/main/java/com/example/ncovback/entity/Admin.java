package com.example.ncovback.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer manager_id;
    private String manager_phone;
    private String manager_password;
    private String manager_name;
    private Integer city_code;
}
