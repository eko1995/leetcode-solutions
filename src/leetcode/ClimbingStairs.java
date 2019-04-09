package leetcode;

/**
 * @author eko
 * @date 2018/10/21 8:15 PM
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 56;
        System.out.println(new ClimbingStairs().climbStairs(n));
    }
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int lastOne = 1;
        int lastTwo = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = lastOne + lastTwo;
            lastOne = lastTwo;
            lastTwo = res;
        }
        return res;
    }
}
