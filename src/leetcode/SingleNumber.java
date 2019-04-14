package leetcode;

/**
 * @author eko
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,-1,1,2,3,-1,3};
        System.out.println(new SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
                result = result^nums[i];
        }
        return result;
    }
}
