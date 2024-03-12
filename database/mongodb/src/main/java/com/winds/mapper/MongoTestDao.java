package com.winds.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import com.winds.domain.Book;

import java.util.Date;
import java.util.List;

@Component
public class MongoTestDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /* 保存对象 */
    public String saveObj(Book book){
        book.setUpdateTime(new Date());
        mongoTemplate.save(book);
        return "success";
    }

    /* 查询所有 */
    public List<Book> findAll(){
        return mongoTemplate.findAll(Book.class);
    }

    /* 根据名称查询 */
    public Book getBookByName(String name){
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query,Book.class);
    }

    /* 更新对象 */
    public String updateBook(Book book){
        Query query = new Query(Criteria.where("_id").is(book.getId()));
        Update update = new Update().set("name",book.getName()).set("updateTime",new Date());
        // updateFirst 更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update, Book.class);
        // updateMulti 更新查询返回结果集的全部
        //mongoTemplate.updateMulti(query,update, Book.class);
        // upsert更新对象不存在则添加
        //mongoTemplate.upsert(query,update,Book.class);
        return "success";
    }

    /* 删除对象 */
    public String deleteBook(int id){
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Book.class);
        return "success";
    }
}
