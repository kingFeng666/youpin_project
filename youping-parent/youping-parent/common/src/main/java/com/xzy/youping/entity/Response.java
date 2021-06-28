package com.xzy.youping.entity;

import lombok.Data;

@Data
public class Response {
    private Integer code = ResponseCode.SUCCESS;//响应码
    private String msg ="成功";//响应信息
    private Object data;//响应数据

    public Response code(Integer code) {
        this.code = code;
        return this;
    }

    public Response msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Response data(Object data) {
        this.data = data;
        return this;
    }
}
