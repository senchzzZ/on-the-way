package com.exp.zsq.lambda;

import com.exp.zsq.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: zhaoshengqi
 * Date: 2019/12/12 下午3:25
 */
public class StreamAndMatchTest {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1l,"netty",3000l,"1.0"));
        list.add(new Book(2l,"java",6000l,"1.0"));
        list.add(new Book(3l,"mysql",2000l,"1.0"));
        list.add(new Book(5l,"docker",4000l,"1.0"));


        boolean flag = list.stream().filter(b -> b.getId() > 2 ).anyMatch(b1 -> b1.getName().equals("docker"));
        boolean flag1 = list.stream().filter(b -> b.getId() > 2 ).allMatch(b1 -> b1.getName().equals("docker"));
        System.out.println(flag);
        System.out.println(flag1);

        list = list.stream().filter(b -> b.getId() > 2 ).collect(Collectors.toList());
        System.out.println(list);

        list = list.stream().filter(b -> b.getId() > 2 ).skip(3).collect(Collectors.toList());
        System.out.println(list);

        //parallel stream
        list = list.parallelStream().filter(b -> b.getId() > 2 ).skip(1).collect(Collectors.toList());
        System.out.println(list);

    }
}
