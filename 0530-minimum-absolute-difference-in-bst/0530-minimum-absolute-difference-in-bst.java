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
    private final List<Integer> nodes = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);

        Collections.sort(nodes);

        int minimumDifference = Integer.MAX_VALUE;

        for (int i = 1; i < nodes.size(); i++) {
            minimumDifference = Math.min(minimumDifference, nodes.get(i) - nodes.get(i - 1));
        }

        return minimumDifference;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        nodes.add(node.val);

        dfs(node.left);
        dfs(node.right);
    }
}