class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int result = 0;
        int count = 0;
        int top = 0;
        for (int i = 1; i < A.length; i++) {
            if (top == 0) {
                if (A[i] > A[i - 1]) {
                    count++;
                } else if (A[i - 1] > A[i] && count > 0) {
                    top = A[i - 1];
                    count++;
                } else {
                    count=0;
                }
            } else {
                if (A[i] < A[i - 1]) {
                    count++;
                } else if (A[i - 1] < A[i - 2]) {
                    result = result > count + 1 ? result : count + 1;
                    count = 0;
                    top = 0;
                }
                if (A[i] > A[i-1]) {
                    count++;
                }
            }
        }
        if (top != 0 && count > 0) {
            result = result > count + 1 ? result : count + 1;
        }

        return result;
    }
}
