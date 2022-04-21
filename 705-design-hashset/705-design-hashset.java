class MyHashSet {

    int[] nums;

    public MyHashSet() {
        nums = new int[1_000_001];
    }

    public void add(int key) {
        nums[key] = 1;
    }

    public void remove(int key) {
        nums[key] = 0;
    }

    public boolean contains(int key) {
        return nums[key] != 0;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */