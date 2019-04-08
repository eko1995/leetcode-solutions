package leetcode;

/**
 * @author eko
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MinimumPathSum().minPathSum(nums));
    }

    public int minPathSum(int[][] grid) {
        int[][] minSum = new int[grid.length][grid[0].length];
        minSum[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            minSum[i][0] = minSum[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            minSum[0][i] = grid[0][i] + minSum[0][i-1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                minSum[i][j] = grid[i][j] + (minSum[i-1][j] < minSum[i][j-1] ? minSum[i-1][j] : minSum[i][j-1]);
            }
        }

        return minSum[grid.length - 1][grid[0].length - 1];
    }
}
