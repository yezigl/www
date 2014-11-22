/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.utils;

import gl.yezi.data.model.time.User;

import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月6日
 */
public class CryptUtils {
    
    private static final String DEFAULT_SALT = "~!@#$%^&*()_+`1234567890-=";
    
    private static final Random RANDOM = new Random();

    public static String salt() {
        return DigestUtils.sha1Hex(RANDOM.nextLong() + DEFAULT_SALT + System.currentTimeMillis());
    }

    /**
     * @param tempUser
     * @return
     */
    public static String token(User user) {
        return null;
    }

}
