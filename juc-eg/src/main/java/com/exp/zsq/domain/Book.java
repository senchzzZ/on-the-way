package com.exp.zsq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: zhaoshengqi
 * Date: 2019/12/12 下午3:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    Long id;
    String name;
    Long price;
    String version;

    public static boolean isCheaperThan(Book book, Long price) {
        return book.getPrice() < price;
    }

    public static boolean isCheaperThan3(Book book) {
        return book.getPrice() < 3000;
    }

    public static boolean isHigherThan(Book book, String version) {
        return book.getVersion().compareTo(version) < 0;
    }

    public static boolean isHigherThan1(Book book) {
        return book.getVersion().compareTo("1.0") > 0;
    }
}
