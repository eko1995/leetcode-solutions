package leetcode;

import java.util.LinkedList;

/**
 * @author eko
 * @date 2018/10/29 10:17 AM
 *
 * Given a binary tree
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Example:
 *
 * Given the following perfect binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersinEachNode {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersinEachNode solution = new PopulatingNextRightPointersinEachNode();
        TreeLinkNode node = solution.new TreeLinkNode(1);
        node.left = solution.new TreeLinkNode(2);
        node.right = solution.new TreeLinkNode(3);
        solution.connect(node);
        System.out.println(node);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeLinkNode prevNode = new TreeLinkNode(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    prevNode = queue.pop();
                } else {
                    prevNode.next = queue.pop();
                    prevNode = prevNode.next;
                }
                if (prevNode.left != null) {
                    queue.offer(prevNode.left);
                }
                if (prevNode.right != null) {
                    queue.offer(prevNode.right);
                }
            }
        }
    }
}
