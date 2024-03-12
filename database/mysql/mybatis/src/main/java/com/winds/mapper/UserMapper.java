package com.winds.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.winds.domain.User;

import java.util.List;

/**
 * 使用@Mapper注解指定这是一个操作数据库的Mapper，不然SpringBoot无法扫描到
 * 有两种方式指明该类是一个Mapper:
 * 1. 在Mapper层对应的类上面添加@Mapper注解即可。但是当我们有很多个mapper时，每个类上都待添加@Mapper注解，比较繁琐
 * 2. 在启动类上添加@MapperScan注解，来扫描一个包下的所有Mapper，如@Mapper("org.winds.mapper"),表示扫描org.winds.mapper包下的所有为Mapper的接口
 */
@Mapper
public interface UserMapper {
    List<User> findAll();
    int addUser(User user);
}
