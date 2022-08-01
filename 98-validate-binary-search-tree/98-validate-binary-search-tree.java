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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        // check for the right most value of left sub tree
        if (root.left != null) {
            TreeNode temp = root.left;
            
            while (temp.right != null) {
                temp = temp.right;
            }
            
            if (temp.val >= root.val) {
                return false;
            }
        }
        
        
        // check for left most value of right sub tree
        if (root.right != null) {
            TreeNode temp = root.right;
            
            while (temp.left != null) {
                temp = temp.left;
            }
            
            if (temp.val <= root.val) {
                return false;
            }
        }
        
        // call recursive functions on left and right sub-tree
        return isValidBST(root.left) && isValidBST(root.right);
    }
}