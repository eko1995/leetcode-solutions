package leetcode;

import java.util.Arrays;

/**
 * @author eko
 * @date 2019/6/22 15:58
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int length = Math.max(as.length, bs.length);
        char[] result = new char[length + 1];
        char flag = '0';
        int i = as.length;
        int j = bs.length;
        while (i > 0 || j >0) {
            int total = flag - '0';
            if (i > 0) total = total + as[i-1] - '0';
            if (j > 0) total = total + bs[j-1] - '0';
            switch (total) {
                case 0:
                    result[length] = '0';
                    flag = '0';
                    break;
                case 1:
                    result[length] = '1';
                    flag = '0';
                    break;
                case 2:
                    result[length] = '0';
                    flag = '1';
                    break;
                case 3:
                    result[length] = '1';
                    flag = '1';
                    break;
            }
            length--;
            i--;
            j--;
        }
        if (flag == '1') {
            result[0] = '1';
            return new String(result);
        }

        return new String(result).substring(1);
    }
}
