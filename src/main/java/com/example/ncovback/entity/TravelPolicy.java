package com.example.ncovback.entity;

import lombok.Data;

@Data
public class TravelPolicy {
    private Integer from_code;
    private String from_city;
    private Integer to_code;
    private String to_city;
    private String  from_policy;
    private String to_policy;
}
