class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        findCombinationSum3(k, n, 1, current, answer);
        
        return answer;
    }
    
    void findCombinationSum3(int k, int n, int start, List<Integer> current, List<List<Integer>> answer) {
        
        if (k == 0 && n == 0) {
            if (!answer.contains(current)) {
                answer.add(new ArrayList<>(current));
            }
            return;
        }
        
        if (k <= 0 || n <= 0) {
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            current.add(i);
            findCombinationSum3(k - 1, n - i, i + 1, current, answer);
            current.remove(current.size() - 1);
        }
    }
}