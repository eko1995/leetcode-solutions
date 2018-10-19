package lintcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet(Arrays.asList(nums1));
        int[] res = new int[nums2.length];
        for(int i = 0; i < nums1.length; i++) {
        	set.add(nums1[i]);
        }
        for(int number : nums2) {
        	if(set.contains(number)) {
        		set.remove(number);
        		res[res.length] = number;
        	}
        }
        return res;
    }
}
