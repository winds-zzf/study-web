package com.winds.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.winds.domain.User;

import java.util.List;

/**
 * Mapper持久层Dao
 * 对于对应的SQL查询语句，可以单独使用Myatis的xml配置文件，也可以使用注解标注
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> queryAll();

    @Select("select * from user where id=#{id}")
    User findUserById(int id);
}
