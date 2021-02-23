package com.exp.zsq;

import java.util.*;

/**
 * @author zhaoshengqi
 * @date 2021/1/19 3:48 下午
 */
public class Foo {
    public static void main(String[] args) {
        String s = "aaaaabbbbcccc";
        System.out.println(getInsertStr(s));
    }

    static Map<Character, Integer> map = new HashMap<>();

    static String getInsertStr(String str) {

        int max = 0;
        char ans = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            }else {
                int count = map.get(str.charAt(i))+1;
                map.put(str.charAt(i), count);
            }

            if (map.get(str.charAt(i)) > max) {
                max = map.get(str.charAt(i));
                ans = str.charAt(i);
            }
        }

        System.out.println("出现次数最多的字符是：" + ans + ", 出现的次数：" + max);

        if (max > str.length()/2)
            return "";

        String[] strs = new String[max];

        for (int i = 0; i < max; i++) {
            strs[i] = ans + "";
        }

        Iterator<Map.Entry<Character,Integer>> iterator= map.entrySet().iterator();

        int si = 0;
        while (iterator.hasNext()) {
            Map.Entry<Character,Integer> entry = iterator.next();
            if (entry.getKey() == ans)
                continue;

            for (int i = 0; i < entry.getValue(); i++) {
                strs[si] = strs[si] + (entry.getKey() + "");
                si++;
                if (si == strs.length)
                    si = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();


    }
}
