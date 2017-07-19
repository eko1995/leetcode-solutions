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
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Stack<Integer> stack = new Stack<Integer>();
        getBinaryTreePathSum(result, root, target, stack, 0);
        return result;
    }

    public void getBinaryTreePathSum(List<List<Integer>> result, TreeNode root, int target, Stack<Integer> stack, int sum) {
        stack.push(root.val);
        sum += root.val;
        if (sum == target && root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<Integer>(stack);
            result.add(list);
            stack.pop();
            return;
        } else {
            if (root.left != null) {
                getBinaryTreePathSum(result, root.left, target, stack, sum);
            }
            if (root.right != null) {
                getBinaryTreePathSum(result, root.right, target, stack, sum);
            }
            stack.pop();
        }
    }
}