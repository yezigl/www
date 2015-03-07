/**
 * Copyright 2013 Sohu.com Inc. All Rights Reserved.
 */
package gl.yezi.web.res;

/**
 * description here
 *
 * @author lukeli
 * @version 1.0 2013-11-22
 */
public enum Status {

    ERROR(-1, "undefined error"),
    
    PARAM_ERROR(400, "parameter %s is required."),
    USER_REGISTERED(401, "username %s has registered."),
    USER_NOT_LOGIN(401, "user doesn't login."),
    USER_NOT_EXIST(401, "user not exist."),
    USERNAME_OR_PASSWORD_ERROR(401, "username or password error."),
    NOT_EXIST(404, "%s");

    private int code;
    private String msg;

    Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
