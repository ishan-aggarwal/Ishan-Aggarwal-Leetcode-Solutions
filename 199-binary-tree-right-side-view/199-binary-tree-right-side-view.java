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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (root == null)
            return list;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
    
        while (!queue.isEmpty()) {
            int size = queue.size(); // store the number of nodes of current layer
            TreeNode node = null;
            while (size > 0) {
                node = queue.poll();
                if (node.left != null) // add next layer's node
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            list.add(node.val); // add the val of last node
        }
        
        return list;
    }

}