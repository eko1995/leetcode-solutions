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
     * @param root the root of binary tree
     * @return the new root
     */
    public TreeNode convertBST(TreeNode root) {
        // Write your code here
        if (root == null) {
            return root;
        }
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        inOrderTraverse(root, nodeList);
        TreeNode newRoot = nodeList.get(nodeList.size()-1);
        for(int i =  nodeList.size()-2; i >= 0 ; i--) {
            nodeList.get(i).val += nodeList.get(i+1).val;
        }

        return root;
    }

    public List<TreeNode> inOrderTraverse( TreeNode root, List<TreeNode> nodeList) {
        if (root.left != null) {
            inOrderTraverse(root.left, nodeList);
        }
        nodeList.add(root);
        if (root.right != null) {
            inOrderTraverse(root.right, nodeList);
        }

        return nodeList;
    }
}