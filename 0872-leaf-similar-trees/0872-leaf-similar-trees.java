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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> sequence1 = new ArrayList<>();
        List<Integer> sequence2 = new ArrayList<>();

        dfs(root1, sequence1);
        dfs(root2, sequence2);

        return sequence1.equals(sequence2);
    }

    private void dfs(TreeNode node, List<Integer> sequence) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            sequence.add(node.val);
        }

        dfs(node.left, sequence);
        dfs(node.right, sequence);
    }
}