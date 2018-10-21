package leetcode;

/**
 * @author eko
 * @date 2018/10/21 8:15 PM
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        int res = new DivideTwoIntegers().divide(10, 3);
        System.out.println(res);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend > 0 && divisor > 0) return divideHelper(-dividend, -divisor);
        else if (dividend > 0 && divisor < 0) return -divideHelper(-dividend, divisor);
        else if (dividend < 0 && divisor > 0) return -divideHelper(dividend, -divisor);
        else return divideHelper(dividend, divisor);
    }

    public int divideHelper(int dividend, int divisor) {
        if (dividend > divisor) return 0;
        int cur = 0, nextDividend = 0;
        while ((divisor << cur) >= dividend && cur < 31 && (divisor << cur) < 0) cur++;
        nextDividend = dividend - (divisor << cur - 1);
        if (nextDividend > divisor) return 1 << cur - 1;
        return (1 << cur - 1) + divide(nextDividend, divisor);
    }
}
