/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.res;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月7日
 */
public class LoginRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int uid;
    private String token;
    private String username;
    private String nickname;
    private String avatar;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
