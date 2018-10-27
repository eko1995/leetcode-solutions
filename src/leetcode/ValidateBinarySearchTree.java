package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eko
 * @date 2018/10/27 3:29 PM
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        TreeNode node = solution.new TreeNode(1);
        node.left = solution.new TreeNode(2);
        node.right = solution.new TreeNode(3);
        boolean res = solution.isValidBST(node);
        System.out.println(res);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inorderTraversal(root, list);
    }

    public boolean inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return true;
        if (!inorderTraversal(root.left, list)) return false;
        if (list.size() == 0) list.add(root.val);
        else {
            if (list.get(list.size() - 1) >= root.val) {
                return false;
            } else {
                list.add(root.val);
            }
        }
        if (!inorderTraversal(root.right, list)) return false;
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
