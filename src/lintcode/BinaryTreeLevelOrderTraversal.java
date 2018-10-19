package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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


public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        queue.add(root);
        buildLevelOrder(queue, list);
        return list;
    }

    public void buildLevelOrder(Queue<TreeNode> queue, ArrayList<ArrayList<Integer>> list) {
        if (queue.peek() == null) return;
        List<TreeNode> insertList = new ArrayList<TreeNode>();
        while (queue.peek() != null) {
            insertList.add(queue.remove());
        }
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < insertList.size(); i++) {
            TreeNode node = insertList.get(i);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            newList.add(node.val);
        }
        list.add(newList);
        buildLevelOrder(queue, list);
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
