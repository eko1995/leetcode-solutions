package leetcode;

/**
 * @author eko
 * @date 2018/10/25 10:28 AM
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int res = new RemoveDuplicatesfromSortedArrayII().removeDuplicates(nums);
        System.out.println(res);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index < 2 || nums[i] > nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
