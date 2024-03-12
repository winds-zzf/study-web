package com.winds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.winds.domain.User;
import com.winds.mapper.UserMapper;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    public List<User> queryAll(){
        return userMapper.queryAll();
    }

    public User findUserById(int id){
        String key = "user_"+id;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        // 判断Redis中是否有键值为key的缓存
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            User user = operations.get(key);
            System.out.println("从缓存中获取数据:"+user.getName());
            System.out.println("-------------------------------------");
            return user;
        }else{  // Redis缓存中没有数据，从数据库中查找
            User user = userMapper.findUserById(id);
            System.out.println("查询数据库获取数据:"+user.getName());
            System.out.println("--------------------------------------");
            /*
             * 写入缓存
             * 注意在保存数据到缓存中时，需要设置超时删除，注意设置超时删除缓存时间不要过长，否则会给服务器带来压力
             */
            operations.set(key,user,5, TimeUnit.HOURS);
            return user;
        }
    }
}
