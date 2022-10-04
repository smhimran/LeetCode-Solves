/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return dfs(root, root.val, targetSum);
    }

    private boolean dfs(TreeNode node, int sum, int targetSum) {
        if (node.left == null && node.right == null) {
            return (sum == targetSum);
        }

        boolean found = false;
        if (node.left != null) {
            found |= dfs(node.left, sum + node.left.val, targetSum);
        }

        if (node.right != null) {
            found |= dfs(node.right, sum + node.right.val, targetSum);
        }

        return found;
    }
}