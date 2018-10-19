package lintcode;

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 * public int start, end, max;
 * public SegmentTreeNode left, right;
 * public SegmentTreeNode(int start, int end, int max) {
 * this.start = start;
 * this.end = end;
 * this.max = max
 * this.left = this.right = null;
 * }
 * }
 */
public class SegmentTreeQuery {
    /**
     * @param root, start, end: The root of segment tree and
     *              an segment / interval
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.end < start || root.start > end || start > end) {
            return Integer.MIN_VALUE;
        }
        if (start <= root.start && end >= root.end) {
            return root.max;
        }
        int leftWall = root.start + (root.end - root.start) / 2;
        int leftMax = query(root.left, start, Math.min(leftWall, end));
        int rightMax = query(root.right, Math.max(leftWall, start), end);
        return Math.max(leftMax, rightMax);
    }

    public class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
            this.max = max;
        }
    }
}
