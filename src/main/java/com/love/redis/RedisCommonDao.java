package com.love.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/20.
 */
public interface RedisCommonDao {


    /**
     * @param redisKey
     * @return
     */
    String getString(String redisKey);

    /**
     * @param redisKey
     * @return
     */
    boolean existsKey(String redisKey);

    /**
     * @param redisKey
     * @param redisValue
     */
    void setString(String redisKey, String redisValue);

    /**
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    void put(String key, String value, long timeout, TimeUnit unit);

    /**
     * @param redisKey
     * @param data
     */
    void incrementString(String redisKey, Long data);

    /**
     * @param redisKey
     * @return
     */
    List<String> getHashKeys(String redisKey);

    /**
     * @param redisKey
     * @return
     */
    Map<String, String> getHash(String redisKey);

    /**
     * @param redisKey
     * @param hashKeyPrefix
     * @return
     */
    Map<String, String> getHashKeyStartsWith(String redisKey, String hashKeyPrefix);

    /**
     * @param redisKey
     * @param hashKeySuffix
     * @return
     */
    Map<String, String> getHashKeyEndsWith(String redisKey, String hashKeySuffix);

    /**
     * @param redisKey
     * @param hashKey
     * @return
     */
    String getHash(String redisKey, String hashKey);

    /**
     * @param redisKey
     * @param hashKey
     * @param hashValue
     */
    void putHash(String redisKey, String hashKey, String hashValue);

    /**
     * @param redisKey
     * @param map
     */
    void putHash(String redisKey, Map<String, String> map);

    /**
     * @param redisKey
     * @param o
     * @return
     */
    boolean isMember(String redisKey, Object o);

    /**
     * @param redisKey
     * @return
     */
    Set<String> getSet(String redisKey);

    /**
     * @param redisKey
     * @param values
     */
    void addSet(String redisKey, String... values);

    /**
     * @param redisKey
     * @param hashKey
     * @param data
     */
    void incrementHash(String redisKey, String hashKey, long data);

    /**
     * @param redisKey
     */
    void delRedisKey(String redisKey);

    /**
     * @param redisKey
     * @param second
     */
    void expire(String redisKey, long second);

    /**
     * @param key
     * @param hour
     */
    void setExpireByHour(String key, Integer hour);

    /**
     * @param key
     * @param day
     */
    void setExpireByDay(String key, Integer day);

    /**
     * 获取key的过期时间
     *
     * @param key
     * @return
     */
    Long getKeyExpire(String key);

    /**
     * @param reidsKey
     * @param field
     * @return
     */
    boolean existsHashKey(String reidsKey, String field);

    /**
     * @param pattern
     * @return
     */
    List<String> scanParams(String pattern);

    /**
     * list 左边入队列
     *
     * @param redisKey
     * @param field
     */
    public void lPushList(String redisKey, String field);

    /**
     * list 右边弹出队列
     *
     * @param redisKey
     */
    public String rPopList(String redisKey);

    /**
     * get list's length
     *
     * @param redisKey
     * @return
     */
    Long getLengthList(String redisKey);

    /**
     * @param redisKey
     * @param hashKey
     */
    void delHash(String redisKey, String hashKey);

    /**
     * @param key
     * @param map
     * @param timeout
     * @param unit
     */
    void putMapAll(String key, Map<String, String> map, int timeout, TimeUnit unit);


}
