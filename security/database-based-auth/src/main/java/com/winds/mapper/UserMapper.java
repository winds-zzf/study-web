package com.winds.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.winds.entiry.UserInfo;

@Mapper
@Repository
public interface UserMapper {
    /* 对于简单的SQL语句，可以使用注解式来替换xml式 */
    @Select("select * from user where username=#{username}")
    UserInfo getUserByUsername(String username);
}
