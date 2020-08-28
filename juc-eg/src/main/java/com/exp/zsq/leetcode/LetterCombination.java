package com.exp.zsq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoshengqi
 * @date 2020/8/26 9:23 上午
 */
public class LetterCombination {

    public static void main(String[] args) {
        LetterCombination lc = new LetterCombination();
        System.out.println(lc.letterCombinations("234"));
    }


    String[][] map = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
    //String[][] comb = new String[][]{};

    public List<String> letterCombinations(String digits) {
        if (digits == null)
            return null;
        if (digits.length() == 1) {
            return Arrays.asList(map[Integer.parseInt(digits.charAt(0) + "")]);
        }
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            int sub = Integer.parseInt(digits.charAt(i) + "");

            if (temp.isEmpty())
                temp.addAll(Arrays.asList(map[sub]));
            else {//组合
                for (String ori : temp) {
                    for (String tar : map[sub]) {
                        res.add(ori + tar);
                    }
                }
                temp = new ArrayList<>();
                temp.addAll(res);
                if (i != digits.length() - 1)
                    res.clear();
            }

        }
        return res;
    }

    /*public String dfs(List<List<String>> list, int cur){
        if (cur >= list.size())
            return null;

        List<String> sub = list.get(cur);

        for (String s : sub) {

        }



    }*/

}
