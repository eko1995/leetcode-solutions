package lintcode;

import java.util.Arrays;

public class MaxNumber {

    public static void main(String[] args) {
        int[] nums = new int[] {50, 2, 1, 9};
        int res = maxNumber(nums);
    }

    public static int maxNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs);
        String res = "";
        for(String str : strs) {
            res = str + res;
        }

        return Integer.valueOf(res);
    }
}
