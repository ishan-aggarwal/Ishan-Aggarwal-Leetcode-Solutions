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
    
    Set<Integer> tree = new HashSet<>();
    
    public boolean findTarget(TreeNode root, int k) {
        return findVal(root,k);
    }
    
    boolean findVal(TreeNode root, int k)
    {
        if (root == null) {
            return false;
        }
        if (tree.contains(k - root.val)) {
            return true;        
        }
        tree.add(root.val);
        return findVal(root.left, k) || findVal(root.right, k);
    }

}