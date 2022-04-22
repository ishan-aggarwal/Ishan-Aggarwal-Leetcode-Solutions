class MyHashMap {

    final int size = (int) Math.pow(10, 6) + 1;
    int[] flag;
    
    public MyHashMap() {
        flag = new int[size];
        Arrays.fill (flag, -1);
    }
    
    public void put(int key, int value) {
        flag[key] = value;
    }
    
    public int get(int key) {
        return flag[key];
    }
    
    public void remove(int key) {
        flag[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */