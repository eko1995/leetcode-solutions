package leetcode;

/**
 * @author eko
 * @date 2018/10/23 7:40 PM
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] res = new PlusOne().plusOne(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        if (digits[index] != 9) {
            digits[index] += 1;
            return digits;
        }
        digits[index] = 0;
        index--;
        while (index >= 0 && digits[index] == 9) {
            digits[index--] = 0;
        }
        if (index < 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            digits[index] += 1;
            return digits;
        }
    }
}
