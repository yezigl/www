/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.user;

import gl.yezi.data.orm.Column;
import gl.yezi.data.orm.Index;

import java.util.Date;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月4日
 */
public class User {

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Index(value = "idx_login")
    @Column(type = "VARCHAR(100)")
    private String login;
    @Column(type = "INTEGER")
    private int regtype;
    @Column(type = "INTEGER")
    private int app;
    @Column(type = "VARCHAR(100)")
    private String password;
    @Column(type = "VARCHAR(100)")
    private String salt;
    @Column(type = "VARCHAR(30)")
    private String nickname;
    @Column(type = "VARCHAR(50)", isNull = true)
    private String email;
    @Column(type = "VARCHAR(20)", isNull = true)
    private String mobile;
    @Column(type = "VARCHAR(20)")
    private String regip;
    @Column(type = "DATETIME")
    private Date ctime;
    @Column(type = "INTEGER")
    private int status;
    @Column(type = "VARCHAR(50)", isNull = true)
    private String avatar;
    @Column(type = "INTEGER")
    private int role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRegtype() {
        return regtype;
    }

    public void setRegtype(int regtype) {
        this.regtype = regtype;
    }

    public int getApp() {
        return app;
    }

    public void setApp(int app) {
        this.app = app;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
