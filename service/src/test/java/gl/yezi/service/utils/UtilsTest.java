/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service.utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月14日
 */
public class UtilsTest {
    
    String ip = "255.255.255.255";

    /**
     * Test method for {@link gl.yezi.service.utils.Utils#ip2long(java.lang.String)}.
     */
    @Test
    public void testIp2long() {
        long l = Utils.ip2long(ip);
        System.out.println(l);
    }

    /**
     * Test method for {@link gl.yezi.service.utils.Utils#long2ip(long)}.
     */
    @Test
    public void testLong2ip() {
        String s = Utils.long2ip(Utils.ip2long(ip));
        System.out.println(s);
    }

}
