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
    private int maximumPathSum;

    public int maxPathSum(TreeNode root) {
        maximumPathSum = Integer.MIN_VALUE;
        dfs(root);
        return maximumPathSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        int currentSum = leftSum + rightSum + node.val;

        maximumPathSum = Math.max(maximumPathSum, currentSum);
        maximumPathSum = Math.max(maximumPathSum, Math.max(leftSum, rightSum) + node.val);
        maximumPathSum = Math.max(maximumPathSum, node.val);

        return Math.max(Math.max(leftSum, rightSum) + node.val, node.val);
    }
}