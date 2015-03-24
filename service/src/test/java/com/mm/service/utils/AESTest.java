/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.service.utils;

import org.junit.Test;

import com.mm.service.utils.AES;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月9日
 */
public class AESTest {
    
    String password = "test password";
    String origin = "1111111";

    @Test
    public void test() {
        String ds = AES.encrypt(origin, password);
        System.out.println(ds);
        String es = AES.decrypt(ds, password);
        System.out.println(es);
    }

}
