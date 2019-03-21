package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author eko
 * @date 2018/10/23 1:39 PM
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int num = -121;
        System.out.println(new PalindromeNumber().isPalindrome(num));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 9) return true;
        String str = String.valueOf(x);
        List<Character> chars = new LinkedList<>();

        for (int i = 0, j = str.length() - 1; i < j; ) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
