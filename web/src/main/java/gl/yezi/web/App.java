/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月6日
 */
public enum App {
    
    TBD(0, "tbd"),
    HOME(1, "beauty"),
    TIME(2, "time");
    
    int code;
    String key;
    
    App(int code, String key) {
        this.code = code;
        this.key = key;
    }
    
    public static App valueOfKey(String key) {
        for (App app : values()) {
            if (app.key.equals(key)) {
                return app;
            }
        }
        return TBD;
    }
    
    public static App valueOfCode(int code) {
        for (App app : values()) {
            if (app.code == code) {
                return app;
            }
        }
        return TBD;
    }
}
