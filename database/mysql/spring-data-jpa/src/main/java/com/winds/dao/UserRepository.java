package com.winds.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.winds.domain.User;
/**
 * UserRepository接口，只需要继承JpaRepository接口。
 * JpaRepository中封装了基本的数据操作方法，有基本的增、删、改、查、分页、排序等
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 相当于select * from t_user where username = ? and password = ?
     * 我们并没有写SQL语句，这是因为在Spring JPA中，只要自定义的方法符合既定规范，Spring Data就会分析开发者意图，从而根据方法名生成相应的SQL查询语句
     */
    User findByUsernameAndPassword(String username,String password);
}
