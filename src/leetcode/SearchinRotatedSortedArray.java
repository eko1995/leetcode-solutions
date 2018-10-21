package leetcode;

/**
 * @author eko
 * @date 2018/10/21 8:52 PM
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int res = new SearchinRotatedSortedArray().search(nums, target);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    public int binarySearch(int low, int hi, int[] nums, int target) {
        if (low > hi) return -1;
        int mid = (low + hi) / 2;
        if (nums[mid] < target) {
            if (nums[mid] > nums[low]) {
                return binarySearch(mid + 1, hi, nums, target);
            } else {
                return Math.max(binarySearch(mid + 1, hi, nums, target), binarySearch(low, mid - 1, nums, target));
            }
        } else if (nums[mid] > target) {
            if (nums[mid] < nums[hi]) {
                return binarySearch(low, mid - 1, nums, target);
            } else {
                return Math.max(binarySearch(mid + 1, hi, nums, target), binarySearch(low, mid - 1, nums, target));
            }
        } else {
            return mid;
        }
    }
}
