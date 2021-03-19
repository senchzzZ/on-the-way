package com.exp.zsq.leetcode;

/**
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * https://leetcode-cn.com/problems/multiply-strings/
 *
 * @author zhaoshengqi
 * @date 2021/3/19 2:07 下午
 */
public class StringMultiply {

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    /**
     * 竖式优化
     * 时间复杂度：O*(*M N*)
     * 空间复杂度：O*(M+N)
     *
     * @param num1
     * @param num2
     * @return
     */
    static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0)
                continue;
            result.append(res[i]);
        }
        return result.toString();
    }

}
