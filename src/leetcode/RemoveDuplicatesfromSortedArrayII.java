package leetcode;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int index = 2, first = 0, second = 1;
        while (index < nums.length) {
            if (nums[index] != nums[second] || nums[first] != nums[second]) {
                first++;
                second++;
                nums[second] = nums[index];
            }
            index++;
        }

        return second + 1;
    }
}
