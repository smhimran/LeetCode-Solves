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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val, root, null);
            return newNode;
        }

        addRow(root, val, depth, 1);
        return root;
    }

    private void addRow(TreeNode node, int val, int depth, int currentDepth) {
        if (node == null) {
            return;
        }
        
        if (currentDepth == depth - 1) {
            TreeNode newLeftNode = new TreeNode(val, node.left, null);
            TreeNode newRightNode = new TreeNode(val, null, node.right);
            node.left = newLeftNode;
            node.right = newRightNode;
            return;
        }

        addRow(node.left, val, depth, currentDepth + 1);
        addRow(node.right, val, depth, currentDepth + 1);
    }
}