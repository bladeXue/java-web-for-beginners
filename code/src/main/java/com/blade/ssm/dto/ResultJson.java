package com.blade.ssm.dto;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ResultJson {

    int code;
    String msg;
    int count;
    Object[] data;

//    public void setAll(HashMap<String, Object> map) {
//
//    }

    // pojo
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
}
