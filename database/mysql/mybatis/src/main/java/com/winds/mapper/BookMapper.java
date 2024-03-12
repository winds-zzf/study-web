package com.winds.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.winds.domain.Book;

import java.util.List;

/**
 * 注意@Mapper是Myatis的注解，而@Repository是Spring的注解
 * 参考[https://blog.csdn.net/fengling_smile/article/details/129853866]
 */
@Mapper
public interface BookMapper {
    @Select("select * from book")
    List<Book> findAll();
}
