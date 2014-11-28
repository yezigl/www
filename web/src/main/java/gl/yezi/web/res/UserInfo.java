/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月7日
 */
public class UserInfo extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int uid;
    @JsonInclude(Include.NON_NULL)
    private String username;
    @JsonInclude(Include.NON_NULL)
    private String nickname;
    @JsonInclude(Include.NON_NULL)
    private String email;
    @JsonInclude(Include.NON_NULL)
    private String phone;
    @JsonInclude(Include.NON_NULL)
    private String alipay;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

}
