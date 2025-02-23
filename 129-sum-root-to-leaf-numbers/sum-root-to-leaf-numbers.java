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

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        findPathSum(root, "");
        return ans;
    }

    public void findPathSum(TreeNode root, String currentPathSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            currentPathSum += root.val;
            ans += Integer.parseInt(currentPathSum);
            return;
        }
        currentPathSum += root.val;
        findPathSum(root.left, currentPathSum);
        findPathSum(root.right, currentPathSum);
    }
}