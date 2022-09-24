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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), answer);
        return answer;
    }
    
    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> answer) {
        if (node == null) {
            return;
        }
        
        path.add(node.val);
        
        if (node.left == null && node.right == null) {
            if (target == node.val) {
                answer.add(new ArrayList<>(path));
            }
        } else {
            dfs(node.left, target - node.val, path, answer);
            dfs(node.right, target - node.val, path, answer);
        }
        
        path.remove(path.size() - 1);
    }
}