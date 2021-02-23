package com.exp.zsq.lambda;

import com.exp.zsq.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Author: zhaoshengqi
 * Date: 2019/12/12 下午4:01
 */
public class FunctionTest {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1l,"netty",3000l,"1.0"));
        list.add(new Book(2l,"java",6000l,"2.0"));
        list.add(new Book(3l,"mysql",2000l,"3.0"));
        list.add(new Book(5l,"docker",4000l,"4.0"));

        //Function
        //Function<Book,String> names = (Book book) -> book.getName();
        Function<Book,String> names = Book::getName;
        System.out.println(names.apply(list.get(0)));


    }

}
