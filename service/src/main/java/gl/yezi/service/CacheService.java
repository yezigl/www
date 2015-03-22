/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service;

import gl.yezi.data.cache.SimpleInnerCache;

import org.springframework.stereotype.Service;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月26日
 */
@Service
public class CacheService {
    
    private SimpleInnerCache<String, Object> innerCache = new SimpleInnerCache<>();

    public boolean set(String key, Object value, int expire) {
        innerCache.put(key, value, expire);
        return true;
    }
    
    public String get(String key) {
        return String.valueOf(innerCache.get(key));
    }
}