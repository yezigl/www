/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service;

import org.springframework.stereotype.Service;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月26日
 */
@Service
public class CacheService {

    public boolean set(String key, Object value, int expire) {
        
        return true;
    }
    
    public String get(String key) {
        return "123456";
    }
}
