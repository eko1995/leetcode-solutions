package leetcode;

/**
 * @author eko
 * @date 2018/10/23 7:34 PM
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid =
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                };

        int res = new UniquePathsII().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < matrix.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            matrix[i][0] = 1;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            matrix[0][i] = 1;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }

        return matrix[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
