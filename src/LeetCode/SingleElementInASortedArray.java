package LeetCode;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        for(int i = 0; i < nums.length - 2; i = i + 2) {
            if(nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
/*

    public class Solution {
        public int singleNonDuplicate(int[] nums) {
            // binary search
            int n=nums.length, lo=0, hi=n/2;
            while (lo < hi) {
                int m = (lo + hi) / 2;
                if (nums[2*m]!=nums[2*m+1]) hi = m;
                else lo = m+1;
            }
            return nums[2*lo];
        }
    }

*/
}
