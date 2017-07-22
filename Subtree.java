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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 != null) {
            return false;
        }
        if (T2 == null) {
            return true;
        }
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        List<TreeNode> list2 = new ArrayList<TreeNode>();

        midOverview(T1, list1);
        midOverview(T2, list2);
        int j = 0;
        for (int i = 0;i <= list1.size()-list2.size(); i++) {
            for (;j < list2.size(); j++) {
                if (list1.get(i+j).val == list2.get(j).val) {
                    continue;
                } else {
                    j = 0;
                    break;
                }
            }
        }
        if (j == list2.size()) {
            return true;
        } else {
            return false;
        }
    }

    public void midOverview(TreeNode root, List<TreeNode> list) {
        list.add(root);
        if (root.left != null) {
            midOverview(root.left, list);
        } else {
            list.add(new TreeNode(0));
        }
        if (root.right != null) {
            midOverview(root.right, list);
        } else {
            list.add(new TreeNode(0));
        }
        return;
    }
}