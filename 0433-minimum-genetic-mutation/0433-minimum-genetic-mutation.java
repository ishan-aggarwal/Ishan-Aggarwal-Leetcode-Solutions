class Solution {
    int min = 100;
    public int minMutation(String start, String end, String[] bank) {
        boolean[] visited = new boolean[bank.length+1];
        minValidMutation(start, end, 0, bank, visited);
        return min == 100 ? -1 : min;
    }
    
    public void minValidMutation(String start, String end, int count, String[] bank, boolean[] visited) {
        if(start.equals(end)) {
            min = Math.min(count, min);
            return;
        }
        
        for(int i = 0; i < bank.length; i++) {
            if(!visited[i] && isOneAway(start, bank[i])) {
                visited[i] = true;
                minValidMutation(bank[i], end, count+1, bank, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isOneAway(String start, String end) {
        int count = 0;
        for(int i = 0; i < start.length() && count < 2; i++) {
            if(start.charAt(i) != end.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
