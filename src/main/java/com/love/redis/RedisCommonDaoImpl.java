package com.love.redis;

import com.love.str.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/20.
 */
//@Repository
public class RedisCommonDaoImpl implements RedisCommonDao {

    // @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String getString(String redisKey) {
        return TryBase.ofc(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForValue().get(redisKey)
        ).get();
    }

    @Override
    public void setString(String redisKey, String redisValue) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForValue().set(redisKey, redisValue)
        );
    }

    @Override
    public void incrementString(String redisKey, Long data) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForValue().increment(redisKey, data)
        );
    }


    @Override
    public boolean existsKey(String redisKey) {
        return TryBase.ofc(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.hasKey(redisKey)
        ).get();
    }

    @Override
    public List<String> getHashKeys(String redisKey) {
        List<String> hashKeys = new ArrayList<>();
        Set<Object> keys = TryBase.ofc(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().keys(redisKey)
        ).get();

        if (CollectionUtils.isEmpty(keys)) {
            return hashKeys;
        }

        for (Object key : keys) {
            hashKeys.add(String.valueOf(key));
        }

        return hashKeys;
    }

    @Override
    public Map<String, String> getHash(String redisKey) {
        return getHashKeyStartsWith(redisKey, null);
    }

    @Override
    public Map<String, String> getHashKeyStartsWith(String redisKey, String hashKeyPrefix) {
        Map<String, String> hash = new HashMap<>();
        List<String> hashKeys = getHashKeys(redisKey);
        if (CollectionUtils.isEmpty(hashKeys)) {
            return hash;
        }
        for (String hashKey : hashKeys) {
            if (!StringUtils.isBlank(hashKeyPrefix) && !hashKey.startsWith(hashKeyPrefix)) {
                continue;
            }
            String value = getHash(redisKey, hashKey);
            if (!StringUtils.isBlank(value)) {
                hash.put(hashKey, value);
            }
        }
        return hash;
    }

    @Override
    public Map<String, String> getHashKeyEndsWith(String redisKey, String hashKeySuffix) {
        Map<String, String> hash = new HashMap<>();
        List<String> hashKeys = getHashKeys(redisKey);
        if (CollectionUtils.isEmpty(hashKeys)) {
            return hash;
        }
        for (String hashKey : hashKeys) {
            if (!StringUtils.isBlank(hashKeySuffix) && !hashKey.endsWith(hashKeySuffix)) {
                continue;
            }
            String value = getHash(redisKey, hashKey);
            if (!StringUtils.isBlank(value)) {
                hash.put(hashKey, value);
            }
        }
        return hash;
    }

    @Override
    public String getHash(String redisKey, String hashKey) {
        return TryBase.ofc(CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().hasKey(redisKey, hashKey)).get() ?
                String.valueOf(TryBase.ofc(CacheConsts.RETRY_TIMES,
                        () -> stringRedisTemplate.opsForHash().get(redisKey, hashKey)).get()) :
                null;
    }

    @Override
    public void put(String key, String value, long timeout, TimeUnit unit) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.boundValueOps(key).set(value, timeout, unit)
        );
    }

    @Override
    public void putHash(String redisKey, String hashKey, String hashValue) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().put(redisKey, hashKey, hashValue)
        );
    }

    @Override
    public void putHash(String redisKey, Map<String, String> map) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().putAll(redisKey, map)
        );
    }

    @Override
    public boolean isMember(String redisKey, Object o) {
        return TryBase.ofc(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForSet().isMember(redisKey, o)
        ).get();
    }

    @Override
    public Set<String> getSet(String redisKey) {
        return TryBase.ofc(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForSet().members(redisKey)
        ).get();
    }

    @Override
    public void addSet(String redisKey, String... values) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForSet().add(redisKey, values)
        );
    }

    @Override
    public void incrementHash(String redisKey, String hashKey, long data) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().increment(redisKey, hashKey, data)
        );
    }

    @Override
    public void delRedisKey(String redisKey) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.delete(redisKey)
        );
    }

    @Override
    public void expire(String redisKey, long second) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.expire(redisKey, second, TimeUnit.SECONDS)
        );
    }

    /**
     * 设置过期时间-以小时为单位
     *
     * @param key
     * @param hour
     */
    @Override
    public void setExpireByHour(String key, Integer hour) {
        expire(key, 60 * 60 * hour);
    }

    /**
     * 设置过期时间-以天为单位
     *
     * @param key
     * @param day
     */
    @Override
    public void setExpireByDay(String key, Integer day) {
        expire(key, 60 * 60 * 24 * day);
    }

    /**
     * 获取该key的过期时间
     *
     * @param key
     * @return
     */
    @Override
    public Long getKeyExpire(String key) {
        return TryBase.ofc(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.getExpire(key)
        ).get();
    }

    @Override
    public boolean existsHashKey(String redisKey, String field) {
        return TryBase.ofc(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().hasKey(redisKey, field)
        ).get();
    }

    @Override
    public List<String> scanParams(String pattern) {
        return TryBase.ofc(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate
                        .execute(new RedisCallback<List<String>>() {
                            @Override
                            public List<String> doInRedis(RedisConnection connection)
                                    throws DataAccessException {
                                List<String> list = new ArrayList<>();
                                StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
                                ScanOptions scanOptions = ScanOptions.scanOptions().match(pattern).count(connection.dbSize()).build();
                                Cursor<byte[]> c = stringRedisConnection.scan(scanOptions);
                                while (c.hasNext()) {
                                    list.add(new String(c.next()));

                                }
                                return list;
                            }
                        })).get();
    }

    @Override
    public void lPushList(String redisKey, String field) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForList().leftPush(redisKey, field)
        );
    }

    @Override
    public String rPopList(String redisKey) {
        return TryBase.ofc(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForList().rightPop(redisKey)
        ).get();
    }

    @Override
    public Long getLengthList(String redisKey) {
        return TryBase.ofc(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForList().size(redisKey)
        ).get();
    }

    @Override
    public void delHash(String redisKey, String hashKey) {
        TryBase.ofr(
                CacheConsts.RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().delete(redisKey, hashKey)
        );
    }


    @Override
    public void putMapAll(String key, Map<String, String> map, int timeout, TimeUnit unit) {
        TryBase.ofr(3, () -> {
            stringRedisTemplate.opsForHash().putAll(key, map);
            stringRedisTemplate.expire(key, timeout, unit);
        });
        try {
            Map<Object, Object> newMap = stringRedisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
