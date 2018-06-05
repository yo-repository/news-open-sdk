package com.yo.news.open.sdk.http;

/**
 * Author:JAN
 * Date:11:29 2018-5-23
 * Note:
 **/
public class ResponseModel {
    private String code;
    private String msg;

    private String data;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
