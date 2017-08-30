package LeetCode;

public class SortColors {
    public void sortColors(int[] nums) {
        int redPoint = 0;
        int bluePoint = nums.length - 1;
        for (int i = 0; i <= bluePoint && redPoint <= bluePoint; ) {
            if (nums[i] == 0) {
                int temp = nums[redPoint];
                nums[redPoint] = nums[i];
                nums[i] = temp;
                redPoint++;
                if (i < redPoint) i++;
            } else if (nums[i] == 2) {
                int temp = nums[bluePoint];
                nums[bluePoint] = nums[i];
                nums[i] = temp;
                bluePoint--;
            } else {
                i++;
            }
        }
    }
}
