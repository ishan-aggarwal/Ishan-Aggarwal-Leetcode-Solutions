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
    public static int func(TreeNode root, int[]max){
        if(root==null) return 0;
		// get left subtree max path sum if it is negative dont take left path
		//sum instead of take it zero
        int left=Math.max(0,func(root.left,max));
		// get  right surbtree max path sum 
        int right=Math.max(0,func(root.right,max));
		// here we are applying same concept of finding the diameter of tree
		//here we are finding  the summation the node value  we get from left 
		//subtree and right tree with current node;
        max[0]=Math.max(max[0],left+right+root.val);
		//  this will  return which path has maxm   path sum 
        return root.val+Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        int []max=new int[1];
        max[0]=Integer.MIN_VALUE;
        func(root,max);
        return max[0];        
    }
}