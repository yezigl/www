/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service.context;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import gl.yezi.service.utils.AES;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月9日
 */
public class Token {

    private static final int DEFAUlT_EXPIRED_TIME = 7 * 24 * 3600 * 1000;

    private static final String SEPERATOR = "|";

    private static final String SEED = "!qaz@wsx#edc";

    private int uid;

    private int placeholder;

    private long ctime;

    public Token(int uid) {
        this.uid = uid;
        this.ctime = System.currentTimeMillis();
    }

    public Token(int uid, long ctime) {
        this.uid = uid;
        this.ctime = ctime;
    }

    public String encrypt() {
        return AES.encrypt(uid + SEPERATOR + placeholder + SEPERATOR + System.currentTimeMillis(), SEED);
    }

    public static Token decrypt(String ts) {
        String s = AES.decrypt(ts, SEED);
        String[] ss = StringUtils.split(s, SEPERATOR);
        if (ss.length != 3) {
            return null;
        }
        int uid = NumberUtils.toInt(ss[0]);
        long ctime = NumberUtils.toLong(ss[2]);
        if (uid == 0 || ctime == 0) {
            return null;
        }

        return new Token(uid, ctime);
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > ctime + DEFAUlT_EXPIRED_TIME;
    }

    public int getUid() {
        return uid;
    }
}
