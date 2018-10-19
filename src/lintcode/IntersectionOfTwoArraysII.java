package lintcode;

import java.util.*;

public class IntersectionOfTwoArraysII {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer,Integer> nums1Map = new HashMap<Integer,Integer>();
        Arrays.stream(nums1).forEach(
                number -> {
                    if(nums1Map.containsKey(number)) {
                        nums1Map.put(number, nums1Map.get(number) + 1);
                    }else {
                        nums1Map.put(number, 1);
                    }
                }
        );
        List<Integer> resList = new ArrayList<>();
        Arrays.stream(nums2).filter(number -> nums1Map.containsKey(number) && nums1Map.get(number) > 0).forEach(
                number -> {
                    nums1Map.put(number, nums1Map.get(number) - 1);
                    resList.add(number);
                }
        );

        int[] res = new int[resList.size()];
        Arrays.setAll(res, resList::get);
        return res;
    }
}
