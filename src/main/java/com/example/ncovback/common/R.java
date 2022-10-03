package com.example.ncovback.common;

import lombok.Data;

@Data
public class R {
    private Integer code;
    private String msg;
    private Object data;

    public  R(){}
    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
