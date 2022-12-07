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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return inorder(root, low, high);
    }

    private int inorder(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }

        int ret = 0;

        ret += inorder(node.left, low, high);
        ret += (node.val >= low && node.val <= high) ? node.val : 0;
        ret += inorder(node.right, low, high);

        return ret;
    }
}