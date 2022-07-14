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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        prepareMap(inorder, valueIndexMap);

        TreeNode root = build(preorder, inorder, valueIndexMap, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }


    private TreeNode build(int[] A, int[] B, Map<Integer, Integer> map, int sPr, int ePr, int sIn, int eIn) {
        

        // if (sPr > ePr) {
        //     return null; 
        // }

        if (sIn > eIn) {
            return null; 
        }

        TreeNode root = new TreeNode(A[sPr]);

        int index = map.get(A[sPr]);
        int x  = index - sIn;

        root.left = build(A, B, map, sPr + 1, sPr + x, sIn, index - 1);
        root.right = build(A, B, map, sPr + x + 1, ePr, index + 1, eIn);

        return root;
    }


    private void prepareMap(int[] B, Map<Integer, Integer> map) {
        for (int i = 0; i < B.length; ++i) {
            map.put(B[i], i);
        }
    }
}