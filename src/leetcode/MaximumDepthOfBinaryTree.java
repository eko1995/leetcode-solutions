package leetcode;


import java.util.LinkedList;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode((2));
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(node));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return level;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

/**
 *
 * simple solution
 *
 *      public int maxDepth(TreeNode root) {
 *         if(root==null){
 *             return 0;
 *         }
 *         return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
 *      }
 *
 */
/