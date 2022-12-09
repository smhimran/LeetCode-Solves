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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int currentMin, int currentMax) {
        if (node == null) {
            return currentMax - currentMin;
        }

        currentMin = Math.min(currentMin, node.val);
        currentMax = Math.max(currentMax, node.val);

        int maxDiffLeft = dfs(node.left, currentMin, currentMax);
        int maxDiffRight = dfs(node.right, currentMin, currentMax);

        return Math.max(maxDiffLeft, maxDiffRight);
    }
}