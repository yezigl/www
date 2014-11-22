/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.time;

import gl.yezi.data.orm.Column;
import gl.yezi.data.orm.Index;

import java.util.Date;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月3日
 */
public class User {

    public static final int STATUS_NORMAL = 0;

    public static final int STATUS_ACTIVE = 1;

    public static final int STATUS_CANCEL = 2;

    public static final int STATUS_FROZEN = 3;

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Index(value = "idx_username")
    @Column(type = "VARCHAR(100)")
    private String username;
    @Column(type = "VARCHAR(100)")
    private String password;
    @Column(type = "VARCHAR(100)")
    private String salt;
    @Column(type = "VARCHAR(30)")
    private String nickname;
    @Column(type = "VARCHAR(50)", isNull = true)
    private String email;
    @Column(type = "VARCHAR(20)", isNull = true)
    private String phone;
    @Column(type = "VARCHAR(20)")
    private String regip;
    @Column(type = "DATETIME")
    private Date ctime;
    @Column(type = "INTEGER")
    private int status;
    @Column(type = "VARCHAR(50)", isNull = true)
    private String alipay;
    @Column(type = "VARCHAR(50)", isNull = true)
    private String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRegip() {
        return regip;
    }

    public void setRegip(String regip) {
        this.regip = regip;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
