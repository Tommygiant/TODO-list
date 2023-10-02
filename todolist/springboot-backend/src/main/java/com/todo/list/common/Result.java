package com.todo.list.common;

import lombok.Data;
@Data
public class Result {

    private int code;
    private String msg;
    private Long total;
    private Object data;

    public static Result fail(){
        return result(400,"fail",0L,null);
    }

    public static Result fail(String msg){
        return result(400,msg,0L,null);
    }

    public static Result suc(){
        return result(200,"success",0L,null);
    }

    public static Result suc(Object data){
        return result(200,"success",0L,data);
    }

    public static Result suc(Object data,Long total){
        return result(200,"success",total,data);
    }

    private static Result result(int code,String msg,Long total,Object data){
        Result res = new Result();
        res.setData(data);
        res.setMsg(msg);
        res.setCode(code);
        res.setTotal(total);
        return res;
    }

}