public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        if (root == null) return root;
        TreeNode max = root;
        if (root.left != null) {
            TreeNode left = maxNode(root.left);
            max = max.val > left.val ? max:left;
        }
        if (root.right != null) {
            TreeNode right = maxNode(root.right);
            max = max.val > right.val ? max:right;
        }
        return max;
    }
}