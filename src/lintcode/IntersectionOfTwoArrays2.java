package lintcode;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays2 {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> resSet = new HashSet<>();
        Arrays.sort(nums2);
        for(int number : nums1) {
            if(resSet.contains(number)) {
                continue;
            }
            if(binarySearch(nums2, number)) {
                resSet.add(number);
            }
        }
        int[] res = new int[resSet.size()];
        int index = 0;
        for(int number : resSet) {
            res[index++] = number;
        }
        return res;
    }

    public boolean binarySearch(int[] nums, int number) {
        int low = 0;
        int high = nums.length;
        while(low + 1 < high) {
            int mid = (low + high)/2;
            if(number < nums[mid]) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if(nums[low] == number) {
            return true;
        }

        return false;
    }
}
