package com.qiu.department.utils;

public class ResultUtil<T>{

    public  static <T> Result sucess(T data){
        return new Result(200,200,"请求成功",data);
    }

    public static <T> Result error(String msg){
        return new Result(500,500,msg,null);
    }

}
