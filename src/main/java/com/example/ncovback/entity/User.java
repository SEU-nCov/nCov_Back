package com.example.ncovback.entity;

import lombok.Data;

@Data
public class User {
    private Integer user_id;
    private String phone;
    private String password;
    private String user_name;
    private String user_identify;
    private Integer code_color;
    private Integer sign_timeleft;
}
