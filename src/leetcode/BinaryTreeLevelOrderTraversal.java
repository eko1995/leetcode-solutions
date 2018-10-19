/**
 * @author eko
 * @date 2018/10/19 10:55 AM
 *
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        TreeNode node = solution.new TreeNode(1);
        node.left = solution.new TreeNode(2);
        node.right = solution.new TreeNode(4);
        node.left.left = solution.new TreeNode(3);
        node.left.right = solution.new TreeNode(5);
        List<List<Integer>> res = solution.levelOrder(node);
        System.out.println(res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.pop();
                list.add(node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
