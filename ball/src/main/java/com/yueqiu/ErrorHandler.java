/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yueqiu.res.Representation;
import com.yueqiu.res.Status;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Representation errorResponse(Exception exception) {
        Representation rep = new Representation();
        rep.setError(Status.SERVER_ERROR, exception.getMessage());
        return rep;
    }

}