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
   
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        dfs(root, 0, 0, map);
        
        List<List<Integer>> answer = new ArrayList<>();
        
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            answer.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    answer.get(answer.size() - 1).add(nodes.poll());
                }
            }
        }
        
        return answer;
    }

    private void dfs(TreeNode root, int hd, int level, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        
        if (root == null) {
            return;
        }
        
        if (!map.containsKey(hd)) {
            map.put(hd, new TreeMap<>());
        }
        
        if (!map.get(hd).containsKey(level)) {
            map.get(hd).put(level, new PriorityQueue<>());
        }
        
        map.get(hd).get(level).offer(root.val);
        dfs(root.left, hd - 1, level + 1, map);
        dfs(root.right, hd + 1, level + 1, map);

    }

    
    
    
    
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
        
//         List<List<Integer>> answer = new ArrayList<>();
//         Map<Integer, List<Integer>> positionMap = new TreeMap<>();
//         verticalTraversalHelper( root, 0, positionMap );
        
//         for(List<Integer> currentVerticalLevel : positionMap.values()) {
//             answer.add(currentVerticalLevel);
//         }
        
//         return answer;
        
//     }
    
//     public void verticalTraversalHelper(TreeNode root, int hd, Map<Integer, List<Integer>> positionMap) {
//         if (root == null) {
//             return;
//         }
        
//         List<Integer> nodes = null;
//         if (positionMap.containsKey(hd)) {
//             nodes = positionMap.get(hd);
//         } else {
//             nodes = new ArrayList<>();
//         }
        
//         nodes.add(root.val);
//         positionMap.put(hd, nodes);
        
        
//         verticalTraversalHelper( root.left, hd - 1, positionMap );
//         verticalTraversalHelper( root.right, hd + 1, positionMap );
//     }
}