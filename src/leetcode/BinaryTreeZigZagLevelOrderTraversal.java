/**
 * @author eko
 * @date 2018/10/19 11:21 AM
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigZagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        BinaryTreeZigZagLevelOrderTraversal solution = new BinaryTreeZigZagLevelOrderTraversal();
        TreeNode node = solution.new TreeNode(1);
        node.left = solution.new TreeNode(2);
        node.right = solution.new TreeNode(4);
        node.left.left = solution.new TreeNode(3);
        node.right.right = solution.new TreeNode(5);
        List<List<Integer>> res = solution.zigzagLevelOrder(node);
        System.out.println(res);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean flag = true;
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> newStack = new Stack<>();
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (flag) {
                    if (node.left != null) newStack.push(node.left);
                    if (node.right != null) newStack.push(node.right);
                } else {
                    if (node.right != null) newStack.push(node.right);
                    if (node.left != null) newStack.push(node.left);
                }
            }
            stack = newStack;
            flag = !flag;
            result.add(list);
        }
        return result;
    }
}



/**
 * Better Solution from Others
 *
 * class Solution {
 *     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
 *         List<List<Integer>> res = new ArrayList<>();
 *
 *         traverse(root, 1, res);
 *
 *         return res;
 *     }
 *
 *     private void traverse(TreeNode node, int lvl, List<List<Integer>> res) {
 *         if(node == null) return;
 *         if(res.size() < lvl) res.add(new LinkedList<Integer>());
 *         LinkedList l = (LinkedList)res.get(lvl-1);
 *         if(lvl % 2 == 0) l.offerFirst(node.val);
 *         else l.offerLast(node.val);
 *
 *         traverse(node.left, lvl+1, res);
 *         traverse(node.right, lvl+1, res);
 *     }
 * }
 */
