class MyHashSet {
    
//     int[] nums;

//     public MyHashSet() {
//         nums = new int[1_000_001];
//     }

//     public void add(int key) {
//         nums[key] = 1;
//     }

//     public void remove(int key) {
//         nums[key] = 0;
//     }

//     public boolean contains(int key) {
//         return nums[key] != 0;
//     }
    
    
        Entry[] bucket;
        int size = 1000;

        public MyHashSet() {
            bucket = new Entry[size];
        }

        public void add(int key) {
            Entry entry = bucket[key % size];
            if (entry == null) {
                bucket[key % size] = new Entry(key, null);
                return;
            }
            Entry preEntry = null;
            while (entry != null) {
                if (entry.val == key)
                    return;
                preEntry = entry;
                entry = entry.next;
            }
            preEntry.next = new Entry(key, null);
        }

        public void remove(int key) {
            Entry entry = bucket[key % size];
            if (entry == null)
                return;
            Entry preEntry = null;
            while (entry != null) {
                if (entry.val == key) {
                    if (preEntry == null) {
                        bucket[key % size] = entry.next;
                    } else {
                        preEntry.next = entry.next;
                    }
                    return;
                }
                preEntry = entry;
                entry = entry.next;
            }
        }

        public boolean contains(int key) {
            Entry entry = bucket[key % size];
            if (entry == null) {
                return false;
            }
            while (entry != null) {
                if (entry.val == key)
                    return true;
                entry = entry.next;
            }
            return false;
        }

        class Entry {
            int val;
            Entry next;

            Entry(int val, Entry next) {
                this.val = val;
                this.next = next;
            }
        }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */