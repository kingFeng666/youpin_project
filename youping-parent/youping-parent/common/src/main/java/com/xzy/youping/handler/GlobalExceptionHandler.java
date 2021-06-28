package com.xzy.youping.handler;

import com.xzy.youping.entity.Response;
import com.xzy.youping.entity.ResponseCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response handlerException(Exception e) {
        Response response = new Response();
        response.code(ResponseCode.FAIL);
        response.msg(e.getMessage());
        return response;
    }


}
