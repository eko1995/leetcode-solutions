package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(nums).forEach(pq::add);
        int res = 0;
        for(int i = 0; i <= nums.length - k; i++) {
            res = pq.poll();
        }

        return res;
    }
}
