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
    private final int MAXIMUM_LEVEL = 34; // 2 * log2(1e5 + 1)
    private final int[] sumAtLevel = new int[MAXIMUM_LEVEL + 1];

    private int maximumLevelReached;

    public int maxLevelSum(TreeNode root) {
         dfs(root, 1);

         int maximumSum = Integer.MIN_VALUE;
         int desiredLevel = 0;

         for (int i = 1; i <= maximumLevelReached; i++) {
             if (sumAtLevel[i] > maximumSum) {
                 maximumSum = sumAtLevel[i];
                 desiredLevel = i;
             }
         }

         return desiredLevel;
    }

    private void dfs(TreeNode node, int level) {
        if (Objects.isNull(node)) {
            return;
        }

        sumAtLevel[level] += node.val;

        maximumLevelReached = Math.max(maximumLevelReached, level);

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}