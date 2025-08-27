class MyHashMap {
    int[] nums;
    public MyHashMap() {
        nums = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -1;
        }
    }
    
    public void put(int key, int value) {
        nums[key] = value;
    }
    
    public int get(int key) {
        return nums[key];
    }
    
    public void remove(int key) {
        nums[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */