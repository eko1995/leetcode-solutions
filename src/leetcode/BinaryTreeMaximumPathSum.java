package leetcode;


/**
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 */
public class BinaryTreeMaximumPathSum {
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(maxPathSum(node));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxPathSum(TreeNode root) {

        maxGain(root);

        return max;

    }

    public static int maxGain(TreeNode root)
    {
        if (root == null) return 0;

        int leftMaxGain = Math.max(maxGain(root.left), 0);
        int rightMaxGain = Math.max(maxGain(root.right), 0);

        int maxGain = leftMaxGain + rightMaxGain + root.val;

        if (maxGain > max)
        {
            max = maxGain;
        }

        return root.val + Math.max(leftMaxGain, rightMaxGain);
    }
}
