package com.winds.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 使用Lombok提供的注解来消除getter/setter和constructor等代码
 */
@Data
@NoArgsConstructor
public class Book {
    private int id;
    private String name;
    private String price;
}
