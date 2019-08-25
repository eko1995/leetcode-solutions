package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eko
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        int n = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = n++;
            }
        }

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = 0;
        while (rows > 0 && cols > 0) {
            if (rows == 1) {
                for (int i = 0; i < cols; i++) {
                    result.add(matrix[n][n+i]);
                }
            } else if (cols == 1) {
                for (int i = 0; i < rows; i++) {
                    result.add(matrix[n+i][n]);
                }
            } else {
                for (int i = 0; i < cols - 1; i++) {
                    result.add(matrix[n][n+i]);
                }

                for (int i = 0; i < rows - 1; i++) {
                    result.add(matrix[n + i][n + cols - 1]);
                }

                for (int i = cols - 1; i > 0; i--) {
                    result.add(matrix[n + rows - 1][n + i]);
                }

                for (int i = rows - 1; i > 0; i--) {
                    result.add(matrix[n + i][n]);
                }
            }
            rows -= 2;
            cols -= 2;
            n++;
        }
        return  result;
    }
}
