/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.user;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月4日
 */
public enum Role {

    MASTER(0), NORMAL(1);

    int code;

    Role(int code) {
        this.code = code;
    }
    
    public static Role valueOfCode(int code) {
        for (Role role : values()) {
            if (role.code == code) {
                return role;
            }
        }
        return NORMAL;
    }
}
