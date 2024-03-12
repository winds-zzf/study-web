package com.winds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winds.domain.Book;
import com.winds.mapper.BookMapper;
import com.winds.service.BookService;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }
}
