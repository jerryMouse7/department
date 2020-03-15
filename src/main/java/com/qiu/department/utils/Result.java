package com.qiu.department.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Result<T> {
    private int code;
    private int status;
    private String msg;
    private T data;

    public Result(String msg){
        code = 200;
        status = 1;
        this.msg = msg;
        data = null;

    }
}
