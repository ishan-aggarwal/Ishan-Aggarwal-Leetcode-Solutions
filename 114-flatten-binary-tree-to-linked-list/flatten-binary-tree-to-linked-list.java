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

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        TreeNode curr = root;
        // set both the pointers to null
        curr.left = null;
        curr.right = null;

        // start joining the right pointer
        if (prev != null) {
            prev.right = curr;
        }
        prev = curr;

        // call left and right subtree recursively

        flatten(leftNode);
        flatten(rightNode);
    }
}