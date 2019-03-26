package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author eko
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public void nextPermutation(int[] nums) {
        int swap = -1;
        for (int i = nums.length - 1; i > 0 ; i--) {
            if (nums[i] > nums[i-1]) {
                swap = i-1;
                break;
            }
        }

        if (swap >= 0) {
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[swap]) {
                    int temp = nums[i];
                    nums[i] = nums[swap];
                    nums[swap] = temp;
                    break;
                }
            }
        }

        Arrays.sort(nums, swap+1, nums.length);
    }
}
