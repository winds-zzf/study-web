package com.winds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.winds.domain.Book;
import com.winds.mapper.MongoTestDao;

import java.util.List;

@RestController
@RequestMapping("/mongo")
public class MongoTestController {
    @Autowired
    private MongoTestDao mongoTestDao;

    @PostMapping("/save")
    public String saveObj(@RequestBody Book book){
        return mongoTestDao.saveObj(book);
    }

    @GetMapping("/findAll")
    public List<Book> findAll(){
        return mongoTestDao.findAll();
    }

    @GetMapping("/findBookByName")
    public Book findBookByName(@RequestParam String name){
        return mongoTestDao.getBookByName(name);
    }

    @PostMapping("/update")
    public String update(@RequestBody Book book){
        return mongoTestDao.updateBook(book);
    }

    @PostMapping("/delOne")
    public String delOne(@RequestParam  int id){
        return mongoTestDao.deleteBook(id);
    }
}
