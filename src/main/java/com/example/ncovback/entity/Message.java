package com.example.ncovback.entity;

import lombok.Data;

@Data
public class Message {
    private Integer message_id;
    private String message_type;
    private Integer user_id;
    private String message_time;
    private String message_detail;
    private String tube_id;
}
