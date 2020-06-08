package com.exp.zsq.lambda;

import com.exp.zsq.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Author: zhaoshengqi
 * Date: 2019/12/12 下午6:03
 */
public class PredicateTest {
    public static void main(String[] args) {
        IntPredicate evenNumbers = (int i) -> i%2 == 0;//无装箱
        evenNumbers.test(200);

        Predicate<Integer> oddNumbers = (Integer i) -> i%2 == 1;//装箱
        oddNumbers.test(101);

        List<Book> list = new ArrayList<>();
        list.add(new Book(1l,"netty",3000l,"1.0"));
        list.add(new Book(2l,"java",6000l,"2.0"));
        list.add(new Book(3l,"mysql",2000l,"3.0"));
        list.add(new Book(5l,"docker",4000l,"4.0"));

        List<Book> result = filterBooks(list, Book::isCheaperThan3);
        System.out.println(result);

        System.out.println(filterBooks(list, b -> b.getId() > 3 || b.getVersion().compareTo("2.0") > 0));
    }

    static List<Book> filterBooks(List<Book> list, Predicate<Book> p) {
        List<Book> result = new ArrayList<>();
        for (Book book : list) {
            if (p.test(book)) {
                result.add(book);
            }
        }
        return result;
    }
}
