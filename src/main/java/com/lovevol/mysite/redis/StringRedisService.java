package com.lovevol.mysite.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StringRedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void setString(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public long incr(String key, long delta){
        long result = 1;
        try {
            result = stringRedisTemplate.opsForValue().increment(key, delta);
        }catch (NullPointerException e){
            stringRedisTemplate.opsForValue().set(key,"1");
        }
        return result;
    }

    public void del(String key){
        stringRedisTemplate.delete(key);
    }

    public void setAppend(String key, String value){
        stringRedisTemplate.opsForSet().add(key,value);
    }

    public Set<String> setGet(String key){
        return stringRedisTemplate.opsForSet().members(key);
    }

    public long removeSet(String key, String value){
        return stringRedisTemplate.opsForSet().remove(key, value);
    }

    public boolean inSet(String key, String value){
        return stringRedisTemplate.opsForSet().isMember(key,value);
    }
}
