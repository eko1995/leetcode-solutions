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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> list =  new ArrayList<Integer>();
        midOrder(root, list);
        if (list.size() == 1) return true;
        for (int i = 1;i < list.size();i++) {
            if (list.get(i) <= list.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    public void midOrder(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            midOrder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            midOrder(root.right, list);
        }
    }
}