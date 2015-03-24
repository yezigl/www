/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.data.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月10日
 */
public class DateUtils {

    public static final String FORMAT = "yyyyMMddHH:mm:ss";

    private static SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);

    public static Date parse(String dateStr) {
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
