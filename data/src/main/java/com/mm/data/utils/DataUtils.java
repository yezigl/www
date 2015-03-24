/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.data.utils;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月3日
 */
public class DataUtils {

    /**
     * @param ss
     * @return
     */
    public static int[] toIntArray(String[] ss) {
        int[] is = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            is[i] = toInt(ss[i]);
        }
        return is;
    }

    public static int toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
