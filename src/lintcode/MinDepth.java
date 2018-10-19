package lintcode;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class MinDepth {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = 1;
        int right = 1;
        if (root.left != null) {
            left += minDepth(root.left);
            if (root.right == null) {
                return left;
            }
        }
        if (root.right != null) {
            right += minDepth(root.right);
            if (root.left == null) {
                return right;
            }
        }

        return left < right ? left : right;
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
