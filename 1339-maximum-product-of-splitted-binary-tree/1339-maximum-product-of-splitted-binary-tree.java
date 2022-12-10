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
    private final Map<TreeNode, Long> sumOfNodes = new HashMap<>();
    private long maximumProduct;
    private long totalSum;
    private final int mod = ((int) 1e9) + 7;

    public int maxProduct(TreeNode root) {
        totalSum = sumOfNodesUsingDfs(root);
        getMaximumProduct(root);
        return (int) (maximumProduct % mod);
    }

    private long sumOfNodesUsingDfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        long leftSum = sumOfNodesUsingDfs(node.left);
        long rightSum = sumOfNodesUsingDfs(node.right);

        long sum = leftSum + rightSum + node.val;

        sumOfNodes.put(node, sum);

        return sum;
    }

    private void getMaximumProduct(TreeNode node) {
        if (node == null) {
            return;
        }

        long sumOfCurrentSubTree = sumOfNodes.get(node);
        long sumOfOtherSubTree = totalSum - sumOfCurrentSubTree;

        long product = sumOfCurrentSubTree * sumOfOtherSubTree;
        maximumProduct = Math.max(maximumProduct, product);

        getMaximumProduct(node.left);
        getMaximumProduct(node.right);
    }
}