package leetcode;

/**
 * @author eko
 * @date 2018/10/20 1:25 PM
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = new ContainerWithMostWater().maxArea(height);
        System.out.println(res);
    }

    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = height[i] > height[j] ? height[j] : height[i];
                int water = h * (j - i);
                res = res > water ? res : water;
            }
        }
        return res;
    }
}


/**
 * Better solution: two pointers
 *
 *     public int maxArea(int[] height) {
 *         int maxarea = 0, l = 0, r = height.length - 1;
 *         while (l < r) {
 *             maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
 *             if (height[l] < height[r])
 *                 l++;
 *             else
 *                 r--;
 *         }
 *         return maxarea;
 *     }
 *
 */
