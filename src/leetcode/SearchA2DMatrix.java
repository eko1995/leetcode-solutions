package leetcode;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int low = 0, high = matrix.length * matrix[0].length - 1, length = matrix[0].length;
        while(low != high) {
            int mid = (low + high) / 2;
            if (matrix[mid/length][mid%length] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return matrix[low/length][low%length] == target;
    }
}
