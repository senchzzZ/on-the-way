package com.exp.zsq.leetcode;

/**
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * PINALSIGYAHRPI
 * Explanation:
 * <p>
 * P     I     N
 * A   L S   I G
 * Y A   H R
 * P     I
 * </p>
 * Created by zhaoshengqi on 2018/9/6.
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    static String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        int n = s.length();
        int factor = 2 * numRows - 2;
        StringBuffer sb = new StringBuffer();
        for (int r = 0; r < numRows; r++) {
            for (int i = 0; i < n; i++) {
                if (r == 0) {
                    if (i * factor >= n)
                        continue;
                    sb.append(s.charAt(i * factor));
                } else if (r == numRows - 1) {
                    if (i * factor + r >= n)
                        continue;
                    sb.append(s.charAt(i * factor + r));
                } else if ((i & 1) == 0) {//even
                    if ((i >> 1) * factor + r >= n)
                        continue;
                    sb.append(s.charAt((i >> 1) * factor + r));
                } else if ((i & 1) == 1) {//odd
                    if (((i + 1) >> 1) * factor - r >= n)
                        continue;
                    sb.append(s.charAt(((i + 1) >> 1) * factor - r));
                }
            }
        }

        return sb.toString();
    }

}
