package com.mmall.common;/**
 * Created by Administrator on 2018/11/25.
 */

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


/**
 * @program: mmall
 * @description: 存放修改密码回答问题的token
 * @author: peipeizx
 * @create: 2018-11-25-17-42
 **/
public class TokenCache {
    public static final String TOKEN_PREFIX = "token_";

    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);
    //LRU算法
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                // 默认的数据加载实现，当调用get取值时，没有key对应的值，就调用这个方法加载
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });
    public static void setKey(String key, String value){
        localCache.put(key, value);
    }
    public static String getKey(String key){
        String value = null;
        try{
            value = localCache.get(key);
            if("null".equals(value)){
                return null;
            }
            return value;
        }catch (Exception e){
            logger.error("localCache get error");
        }
        return null;
    }
}
