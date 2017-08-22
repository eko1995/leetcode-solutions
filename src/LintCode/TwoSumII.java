package LintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        int sum = numbers[low] + numbers[high];
        while (sum != target) {
            if (sum < target) {
                low++;
            } else {
                high--;
            }
            sum = numbers[low] + numbers[high];
        }
        return new int[]{low + 1, high + 1};
    }
}
