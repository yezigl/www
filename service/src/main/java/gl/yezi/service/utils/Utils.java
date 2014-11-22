/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service.utils;

import org.apache.commons.lang3.StringUtils;

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
}
