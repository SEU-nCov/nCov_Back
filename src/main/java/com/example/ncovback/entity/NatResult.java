package com.example.ncovback.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class NatResult {
    private Integer nat_id;
    private Integer user_id;
    private String user_name;
    private Integer nat_pointid;
    private String nat_pointname;
    private Integer nat_peopleid;
    private String tp_name;
    private Date nat_time;
    private String nat_result;
    private String tube_id;
    private List<Integer> user_list;
}
