package leetcode;

/**
 * @author eko
 * @date 2018/10/20 1:25 PM
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
