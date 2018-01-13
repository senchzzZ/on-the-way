package com.exp.zsq.juc;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2018/1/4.
 */
public class ConcurrentHashMapNewSpaciality {
    private static ConcurrentHashMap map = new ConcurrentHashMap();
    public static void main(String[] args) {
        map.put("a","this is v a");
        map.put("b","this is v b");
        map.put("c","this is v c");
        map.put("d","this is v d");

        //foreach
        System.out.println("------foreach----------");
        map.forEach((k,v) -> System.out.println("key = "+k + ",value=" + v));

        map.forEach(2,(k,v) -> {
            map.put(k,"new "+v);
            System.out.println(v);
        });

        map.forEach(2, (k,v) -> {
            return "get v "+v;
        },u -> {
            System.out.println(u);
        });

        //compute 对于指定key调用Function 返回新value
        System.out.println("------compute----------");
        System.out.println(map.compute("c",(k,v) -> "new" + v));

        //computeIfAbsent 不存在指定key才执行function，插入function返回的值
        System.out.println("-----computeIfAbsent---------");
        System.out.println(map.computeIfAbsent("e",k -> "computeIfAbsent!"));

        //computeIfPresent 存在指定key才执行function，替换function返回的值，function为空删除指定k-v
        System.out.println("------computeIfPresent----------");
        System.out.println(map.computeIfPresent("b",(k,v) -> {
            String oldV = (String) map.get(k);
            System.out.println("oldV = "+ oldV);
            return "computeIfPresent";
        }));

        //merge key不存在插入给定value，否则执行function
        System.out.println("------merge----------");
        String newV = "merge ";
        System.out.println(map.merge("d",newV,(k,v) -> {
            String oldV = (String) map.get("d");
            System.out.println("oldV = "+ oldV);

            return newV + oldV;
        }));

        //search
        System.out.println("------search----------");
        System.out.println("got u : "+map.search(2,(k,v) -> {
            System.out.println("the search function get " + v);
            map.put("b","new search");
            if (k == "c")
                return v;
            return null;
        }));

        //reduce
        System.out.println("------reduce----------");
        ConcurrentHashMap<String, Integer> reducedMap = new ConcurrentHashMap<>();
        reducedMap.put("One", 1);
        reducedMap.put("Two", 2);
        reducedMap.put("Three", 3);
        reducedMap.put("four", 4);
        reducedMap.put("five", 5);
        System.out.println("" + reducedMap.reduce(1,(k,v) -> {
            System.out.println("key = "+k + ",value=" + v);
            return v*2;
        },(t,u) -> {
            System.out.println("t = "+t + ",u=" + u);
            return t+u;
        }));


        //mappingCount
        System.out.println("------mappingCount----------");
        System.out.println(map.size());
        System.out.println(map.mappingCount());

        //KeySetView
        System.out.println("------KeySetView----------");
        ConcurrentHashMap.KeySetView set = map.newKeySet();
        set.addAll(Arrays.asList("set1","set2"));
        System.out.println(map.keySet("keySet"));



    }
}
