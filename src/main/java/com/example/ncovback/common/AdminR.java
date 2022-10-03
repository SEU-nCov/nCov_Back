package com.example.ncovback.common;

import com.example.ncovback.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class AdminR {
    private Integer code;
    private String msg;
    private List<Menu> menu;
    private Integer token;

    public AdminR(){}
    public AdminR(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
