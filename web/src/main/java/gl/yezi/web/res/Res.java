/**
 * Copyright 2013 Sohu.com Inc. All Rights Reserved.
 */
package gl.yezi.web.res;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * description here
 * 
 * @author lukeli
 * @version 1.0 2013-11-22
 */
public class Res implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    protected Integer code;

    @JsonInclude(Include.NON_NULL)
    protected String msg;
    
    public Res() {
        
    }
    
    public Res(Status status) {
        this.code = status.code();
        this.msg = status.msg();
    }

    public Integer getCode() {
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

    public void setStatus(Status status, Object... args) {
        this.code = status.code();
        this.msg = String.format(status.msg(), args);
        
    }

}
