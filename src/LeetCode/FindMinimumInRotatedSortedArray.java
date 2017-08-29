package LeetCode;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int min = nums[0];
        for (int num : nums)
            if (num < min) {
                min = nums[0];
            }

        return min;
    }
}
