package lintcode;

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


public class ConstructBinaryTree {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        while (inorder[i] != root.val) {
            i++;
        }
        if (i != 0) {
            int[] newPreoder = new int[i];
            int[] newInorder = new int[i];
            System.arraycopy(preorder, 1, newPreoder, 0, i);
            System.arraycopy(inorder, 0, newInorder, 0, i);
            root.left = buildTree(newPreoder,newInorder);
        }
        if (i != inorder.length - 1) {
            int j = inorder.length - 1 - i;
            int[] newPreoder = new int[j];
            int[] newInorder = new int[j];
            System.arraycopy(preorder, i+1, newPreoder, 0, j);
            System.arraycopy(inorder, i+1, newInorder, 0, j);
            root.right = buildTree(newPreoder,newInorder);
        }

        return root;
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
