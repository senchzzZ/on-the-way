package com.exp.zsq.lambda;

import com.exp.zsq.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Author: zhaoshengqi
 * Date: 2019/12/12 下午6:11
 */
public class ConsumerTest {

    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1l,"netty",3000l,"1.0"));
        list.add(new Book(2l,"java",6000l,"1.0"));
        list.add(new Book(3l,"mysql",2000l,"1.0"));
        list.add(new Book(5l,"docker",4000l,"1.0"));
        //foreach
        Consumer<Book> bookConsumer = System.out::println;
        Consumer<Book> bookConsumer2 = (Book book) -> System.out.println(book.getName());
        list.forEach(bookConsumer);
        list.forEach(bookConsumer2);
    }
}
