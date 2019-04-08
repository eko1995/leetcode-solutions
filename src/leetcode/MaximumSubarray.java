package leetcode;

/**
 * @author eko
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] maxNums = new int[nums.length];
        int max = nums[0];
        maxNums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxNums[i] = nums[i] + (maxNums[i-1] > 0 ? maxNums[i-1] : 0);
            max = Math.max(max, maxNums[i]);
        }
        return max;
    }
}
