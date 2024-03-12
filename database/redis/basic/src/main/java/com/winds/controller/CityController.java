package com.winds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.winds.domain.City;

@RestController
public class CityController {
    /*
     * 在SpringBoot中Redis默认提供RedisTemplate和StringRedisTemplate这两个模板类
     */
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/")
    public void testRedis(){
        /*
         * 使用redistemplate操作redis，随后在客户端keys * 查询，发现key值多了前缀，但是不影响程序读写
         * 经查阅资料，是RedisTemplate默认序列化方式用的是JdkSerializationRedisSerializer，
         * 只需将key序列化方式改成StringRedisSerializer，将value序列化方式改为Jackson2JsonRedisSerializer
         */
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        // 添加字符串
        ops.set("name","beixi");
        String name = ops.get("name");
        System.out.println(name);

        ValueOperations opsForValue = redisTemplate.opsForValue();
        City city = new City(1,"北京","中国");
        // 添加实体类
        opsForValue.set("city",city);
        Boolean exists = redisTemplate.hasKey("city");
        System.out.println("redis是否存在相应的key:"+exists);
        // 删除
        redisTemplate.delete("city");
        // 更新
        redisTemplate.opsForValue().set("city",new City(2,"山西","中国"));
        // 查询
        City c2 = (City) redisTemplate.opsForValue().get("city");
        System.out.println("从redis数据库中获取city:"+c2);
    }
}
