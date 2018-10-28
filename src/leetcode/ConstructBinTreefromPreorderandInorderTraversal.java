package leetcode;

/**
 * @author eko
 * @date 2018/10/28 9:20 PM
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = new ConstructBinTreefromPreorderandInorderTraversal().buildTree(preorder, inorder);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree0(preorder, 0, inorder, 0, inorder.length);
    }

    public TreeNode buildTree0(int[] preorder, int start0, int[] inorder, int start1, int len) {
        if (len == 0) return null;
        TreeNode root = new TreeNode(preorder[start0]);
        int start = start1;
        int i = 0;
        for (; inorder[start] != root.val; i++) {
            start++;
        }
        root.left = buildTree0(preorder, start0 + 1, inorder, start1, i);
        root.right = buildTree0(preorder, start0 + i + 1, inorder, start1 + i + 1, len - i - 1);
        return root;
    }
}
