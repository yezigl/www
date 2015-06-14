/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月7日
 */
public class UserRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    private int id;
    @JsonInclude(Include.NON_NULL)
    private String mobile;
    @JsonInclude(Include.NON_NULL)
    private String nickname;
    @JsonInclude(Include.NON_NULL)
    private String avatar;

    public UserRes() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}