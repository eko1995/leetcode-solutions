package LintCode;

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 * public int start, end, count;
 * public SegmentTreeNode left, right;
 * public SegmentTreeNode(int start, int end, int count) {
 * this.start = start;
 * this.end = end;
 * this.count = count;
 * this.left = this.right = null;
 * }
 * }
 */
public class SegmentTreeQueryII {
    /**
     * @param root, start, end: The root of segment tree and
     *              an segment / interval
     * @return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null || start > end || start > root.end || end < root.start) return 0;
        if (root.start == root.end) return root.count;
        int leftWall = (root.start + root.end) / 2;
        int left = 0;
        int right = 0;
        if (start <= leftWall) {
            if (end > leftWall) {
                left = query(root.left, start, leftWall);
                right = query(root.right, leftWall + 1, end);
            } else {
                left = query(root.left, start, end);
            }
        } else {
            right = query(root.right, start, end);
        }

        return left + right;
    }

    public class SegmentTreeNode {
        public int start, end, count;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }

}