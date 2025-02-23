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

    int count = 1;
    int element = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return element;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        if (count == k) {
            element = root.val;
        }
        count++;
        inorder(root.right, k);
    }
}