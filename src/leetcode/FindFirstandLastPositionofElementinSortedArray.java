package leetcode;

/**
 * @author eko
 * @date 2018/10/21 8:59 PM
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = new FindFirstandLastPositionofElementinSortedArray().searchRange(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] searchRange(int[] A, int target) {
        int start = binarySearch(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, binarySearch(A, target + 1) - 1};
    }

    public int binarySearch(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
