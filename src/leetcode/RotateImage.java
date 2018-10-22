package leetcode;

/**
 * @author eko
 * @date 2018/10/22 10:24 AM
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
          {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9}
        };

        new RotateImage().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public void rotate(int[][] matrix) {
        for (int i = 1; 2 * i <= matrix.length; i++) {
            rotateCycle(matrix, i - 1);
        }
    }

    public void rotateCycle(int[][] matrix, int start) {
        int length = matrix.length - 2 * start;
        for (int i = 0; start + i != matrix.length - 1 - start; i++) {
            int t = matrix[start + i][start + length - 1];
            matrix[start + i][start + length - 1] = matrix[start][start + i];
            matrix[start][start + i] = matrix[start + length - 1 - i][start];
            matrix[start + length - 1 - i][start] = matrix[start + length - 1][start + length - 1 - i];
            matrix[start + length - 1][start + length - 1 - i] = t;
        }
    }
}
