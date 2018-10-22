package leetcode;

/**
 * @author eko
 * @date 2018/10/22 9:47 AM
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 3;
        int res = new SearchInsertPosition().searchInsert(nums, target);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int hi = nums.length - 1;
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return nums[low] >= target ? low : low + 1;
    }
}
