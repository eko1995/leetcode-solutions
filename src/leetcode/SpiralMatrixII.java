package leetcode;

/**
 * @author eko
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static int[][] generateMatrix(int n) {
        if (n == 0) return new int[0][0];
        int[][] matrix = new int[n][n];
        int index = n;
        int count = 1;
        int layer = 0;
        while (count <= n * n) {
            if (index == 1) {
                matrix[layer][layer] = count++;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    matrix[layer][layer + i] = count++;
                }

                for (int i = 0; i < index - 1; i++) {
                    matrix[layer + i][layer + index - 1] = count++;
                }

                for (int i = index - 1; i > 0; i--) {
                    matrix[layer + index - 1][layer + i] = count++;
                }

                for (int i = index - 1; i > 0; i--) {
                    matrix[layer + i][layer] = count++;
                }
            }
            index -= 2;
            layer++;
        }
        return  matrix;
    }
}
