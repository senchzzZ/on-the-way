package com.filter;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.io.*;
import java.util.*;

/**
 * Created by zhaoshengqi on 2018/1/25.
 */
public class SFileter {

    private static Map sensitiveWordMap;

    public static void main(String[] args) {
        Set<String> set = readWordFromFile("keywords");
        addSensitiveWordToHashMap(set);

        System.out.println(checkSensitiveWord("操fuck傻逼个狗", 0, 1));


        /*String str = "习近平";
        System.out.println(set.contains(str.trim()));*/
    }

    private static Set<String> readWordFromFile(String path) {
        Set<String> words;
        BufferedReader br = null;
        try {

            br = new BufferedReader(new InputStreamReader(SFileter.class.getClassLoader().getResourceAsStream(path)));
            words = new HashSet<>();
            for (String buf = ""; (buf = br.readLine()) != null; ) {
                if (buf == null || buf.trim().equals(""))
                    continue;
                words.add(buf);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
            }
        }
        return words;
    }

    private static void addSensitiveWordToHashMap(Set<String> keyWordSet) {
        sensitiveWordMap = new HashMap(keyWordSet.size());     //初始化敏感词容器，减少扩容操作
        String key = null;
        Map nowMap = null;
        Map<String, String> newWorMap = null;
        //迭代keyWordSet
        Iterator<String> iterator = keyWordSet.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();    //关键字
            nowMap = sensitiveWordMap;
            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i);       //转换成char型
                Object wordMap = nowMap.get(keyChar);       //获取

                if (wordMap != null) {        //如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                } else {     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<String, String>();
                    newWorMap.put("isEnd", "0");     //不是最后一个
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (i == key.length() - 1) {
                    nowMap.put("isEnd", "1");    //最后一个
                }
            }
        }
    }

    public static int checkSensitiveWord(String txt, int beginIndex, int matchType) {
        boolean flag = false;    //敏感词结束标识位：用于敏感词只有1位的情况
        int matchFlag = 0;     //匹配标识数默认为0
        char word = 0;
        int maxMatchFlag = 0; //最大匹配度
        Map nowMap = sensitiveWordMap;

        for (int i = beginIndex; i < txt.length();) {
            word = txt.charAt(i);
            nowMap = (Map) nowMap.get(word);     //获取指定key

            if (MapUtils.isNotEmpty(nowMap)) {     //存在，则判断是否为最后一个
                ++matchFlag;
                ++i;//匹配成功才继续下一个字
                if ("1".equals(nowMap.get("isEnd"))) {       //如果为最后一个匹配规则
                    flag = true;       //结束标志位为true
                    nowMap = sensitiveWordMap;//从下一个字开始重新匹配
                    if (maxMatchFlag < matchFlag)
                        maxMatchFlag = matchFlag;
                    matchFlag = 0;
                    if (-1 == matchType) {    //最小规则，直接返回,最大规则还需继续查找
                        break;
                    }
                }
            } else if (i == txt.length()-1)//剩最后一个字就不作匹配了
                break;
            else {     //不存在，从下一个字开始重新查找
                nowMap = sensitiveWordMap;
                matchFlag = 0;
                ++i;
            }

            if (maxMatchFlag < matchFlag)
                maxMatchFlag = matchFlag;
        }


        if (maxMatchFlag < 2 && !flag) {
            maxMatchFlag = 0;
        }
        return maxMatchFlag;
    }

}
