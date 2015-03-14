/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.res;

import gl.yezi.data.model.user.User;

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
    private int uid;
    @JsonInclude(Include.NON_NULL)
    private String login;
    @JsonInclude(Include.NON_NULL)
    private String nickname;
    @JsonInclude(Include.NON_NULL)
    private String email;
    @JsonInclude(Include.NON_NULL)
    private String mobile;

    public UserRes() {

    }

    public UserRes(User user) {
        uid = user.getId();
        login = user.getLogin();
        nickname = user.getNickname();
        email = user.getNickname();
        mobile = user.getMobile();
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
