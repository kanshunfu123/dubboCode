package com.xiaowei.sys.platform.core.facade.service.util;


import com.xiaowei.sys.platform.core.facade.service.redis.SSORedisClientTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * <p>redis通用工具类</p>
 *
 * @author bigSea
 */
public class SSORedisUtil<T> {

    private final static Logger log= LoggerFactory.getLogger(SSORedisUtil.class);

    public final static String REDIS_RES = "OK";


    private SSORedisClientTemplate redisClientTemplate;

    /**
     * 向缓存中设置 String   类型
     *
     * @param key
     * @param value
     * @return
     */
    public  boolean setString(String key, String value) {
        boolean res = false;
        SSORedisClientTemplate redisCacheClient = redisClientTemplate;
        String result = redisCacheClient.set(key, value);
        if (REDIS_RES.equals(result)) {
            res = true;
        }
        return res;
    }

    /**
     * 向缓存中设置对象
     *
     * @param key
     * @param value
     * @return
     */
    public  boolean setEntity(String key, Object value) {
        boolean res = false;
        String objectJson = JsonUtils.object2Json(value);
        SSORedisClientTemplate redisCacheClient = redisClientTemplate;
        String result = redisCacheClient.set(key, objectJson);
        if (REDIS_RES.equals(result)) {
            res = true;
        }
        return res;
    }

    /**
     * 向缓存中设置 list 集合
     * @param key
     * @param value
     * @return
     */
    public boolean setList(String key,List<T> value){
        boolean res = false;
        String objectJson = JsonUtils.list2Json(value);
        SSORedisClientTemplate redisCacheClient = redisClientTemplate;
        String result = redisCacheClient.set(key, objectJson);
        if (REDIS_RES.equals(result)) {
            res = true;
        }
        return res;
    }

    /**
     * 删除缓存中得对象，根据key
     *
     * @param key
     * @return
     */
    public  boolean del(String key) {
        SSORedisClientTemplate redisCacheClient = redisClientTemplate;
        Long result = redisCacheClient.del(key);
        System.out.println("del:" + result);
        return true;
    }

    /**
     * 根据key 获取内容
     *
     * @param key
     * @return
     */
    public  Object get(String key) {
        SSORedisClientTemplate redisCacheClient = redisClientTemplate;
        Object value = redisCacheClient.get(key);
        return value;
    }


    /**
     * 根据key 获取对象
     *
     * @param key
     * @return
     */
    public  <T> T getEntity(String key, Class<T> clazz) {
        try {
            SSORedisClientTemplate redisCacheClient = redisClientTemplate;
            String value = redisCacheClient.get(key);
            if (JcStringUtils.isNotNullOrBlank(value)) {
                return (T) JsonUtils.json2Ojbect(value, clazz);
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
    public  List<T>  getList(String key, Class<T> clazz) {
        try {
            SSORedisClientTemplate redisCacheClient = redisClientTemplate;
            String value = redisCacheClient.get(key);
            if (JcStringUtils.isNotNullOrBlank(value)) {
                return JsonUtils.json2List(value, clazz);
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 在某段时间后失效
     *
     * @param key
     * @return
     */
    public  boolean expire(String key, int seconds) {
        SSORedisClientTemplate redisCacheClient = redisClientTemplate;
        Long result = redisCacheClient.expire(key, seconds);
        System.out.println("expire:" + result);
        return true;
    }


    public SSORedisClientTemplate getRedisClientTemplate() {
        return redisClientTemplate;
    }

    public void setRedisClientTemplate(SSORedisClientTemplate redisClientTemplate) {
        this.redisClientTemplate = redisClientTemplate;
    }
}
