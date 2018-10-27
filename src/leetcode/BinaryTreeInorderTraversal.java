package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author eko
 * @date 2018/10/27 3:20 PM
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        TreeNode node = solution.new TreeNode(1);
        node.right = solution.new TreeNode(2);
        node.right.left = solution.new TreeNode(3);
        List<Integer> res = solution.inorderTraversal(node);
        System.out.println(res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
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
