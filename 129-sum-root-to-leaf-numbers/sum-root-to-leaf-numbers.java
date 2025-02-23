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
    public int sumNumbers(TreeNode root) {

        List<String> paths = new ArrayList<>();
        String current = "";

        findPaths(root, current, paths);
        
        int sum = 0;
        for (String path : paths) {
            sum += Integer.parseInt(path);
        }
        return sum;
    }

    public void findPaths(TreeNode root, String current, List<String> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(current+root.val);
            return;
        }
        findPaths(root.left, current+root.val, paths);
        findPaths(root.right, current+root.val, paths);
    }
}