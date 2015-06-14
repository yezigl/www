/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
public class Representation {

    @JsonInclude(Include.NON_NULL)
    private Error error;
    @JsonInclude(Include.NON_NULL)
    private Object data;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setError(Status status, Object... args) {
        error = new Error();
        error.setCode(status.code());
        error.setMessage(String.format(status.msg(), args));
    }

}
