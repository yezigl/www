/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月6日
 */
public class Utils {

    /**
     * 解析IP, 第一个不为unknown的ip
     * 
     * @param xff
     *            X-Forwarded-For
     * @param xrip
     *            X-Real-IP
     * @return
     */
    public static String getClientIP(String forwardIp, String realIp) {
        String ip = forwardIp != null ? forwardIp : realIp;
        if (StringUtils.isBlank(ip)) {
            return "";
        }
        String[] ips = ip.replaceAll(" ", "").split(",");
        for (String clientIp : ips) {
            if (StringUtils.isNotBlank(clientIp) && !clientIp.equalsIgnoreCase("unknown")) {
                return clientIp;
            }
        }
        return "";
    }

    public static long ip2long(String ip) {
        String[] ss = StringUtils.split(ip, ".");
        if (ss.length != 4) {
            return 0;
        }
        return (NumberUtils.toLong(ss[0]) << 24) + (NumberUtils.toLong(ss[1]) << 16) + (NumberUtils.toLong(ss[2]) << 8)
                + NumberUtils.toLong(ss[3]);
    }

    public static String long2ip(long ip) {
        return (ip >>> 24 & 0xFF) + "." + (ip >>> 16 & 0xFF) + "." + (ip >>> 8 & 0xFF) + "." + (ip & 0xFF);
    }
}
