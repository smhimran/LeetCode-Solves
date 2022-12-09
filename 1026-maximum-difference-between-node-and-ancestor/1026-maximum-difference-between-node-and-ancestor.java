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
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    int maximumDifference = 0;

    public int maxAncestorDiff(TreeNode root) {
        parentMap.put(root, root);
        dfs(root);
        return maximumDifference;
    }

    private void dfs(TreeNode node) {
        if (node.left != null)         {
            parentMap.put(node.left, node);
            calculate(node, node.left);
            dfs(node.left);
        }

        if (node.right != null) {
            parentMap.put(node.right, node);
            calculate(node, node.right);
            dfs(node.right);
        }
    }

    private void calculate(TreeNode node, TreeNode current) {
        int difference = Math.abs(node.val - current.val);

        maximumDifference = Math.max(maximumDifference, difference);
        
        TreeNode ancestor = parentMap.get(node);
        
        if (ancestor.equals(node)) {
            return;
        }

        calculate(ancestor, current);
    }
}