package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendFreq = new HashMap<>();
        for(int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        for(int num : nums) {
            if (freq.getOrDefault(num, 0) == 0) continue;
            else if (appendFreq.getOrDefault(num, 0) > 0) {
                appendFreq.put(num, appendFreq.getOrDefault(num, 0) - 1);
                appendFreq.put(num + 1, appendFreq.getOrDefault(num+1, 0) + 1);
            } else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                freq.put(num + 1, freq.getOrDefault(num + 1, 0) - 1);
                freq.put(num + 2, freq.getOrDefault(num + 2, 0) - 1);
                appendFreq.put(num + 3, appendFreq.getOrDefault(num + 3, 0) + 1);
            } else return false;
            freq.put(num, freq.getOrDefault(num, 0) -1);
        }

        return true;
    }
}
