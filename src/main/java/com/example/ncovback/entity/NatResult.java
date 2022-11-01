package com.example.ncovback.entity;

import lombok.Data;

import java.util.Date;
@Data
public class NatResult {
    private Integer nat_id;
    private Integer user_id;
    private Integer nat_pointid;
    private Integer nat_peopleid;
    private Date nat_time;
    private String nat_result;
    private Integer tube_id;
    private String nat_pointname;
    private String user_name;
}
