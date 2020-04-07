package com.mly.mango.backup.utils;

import lombok.Data;

/**
 * @author wyn
 * @Description http结果封装
 * @date 2020-04-04 17:21
 */
@Data
public class HttpResult {

    private int code =200;
    private String msg;
    private Object data;

    public static HttpResult error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,"未知异常，请联系管理员");
    }

    public static HttpResult error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,msg);
    }

    public static HttpResult error(int code ,String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(code);
        httpResult.setMsg(msg);
        return httpResult;
    }


    public static HttpResult ok(String msg){

        HttpResult httpResult = new HttpResult();
        httpResult.setMsg(msg);
        return httpResult;
    }

    public static HttpResult ok(Object data){
        HttpResult httpResult = new HttpResult();
        httpResult.setData(data);
        return httpResult;
    }

    public static HttpResult ok(){
        return new HttpResult();
    }
}
