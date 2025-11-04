class Solution {

    static class Pair implements Comparable<Pair> {
        private int num;
        private int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair other) {
            // Sort by frequency descending, then by value descending
            if (this.freq != other.freq)
                return Integer.compare(other.freq, this.freq);
            return Integer.compare(other.num, this.num);
        }
    }


    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        // Build initial frequency map for first window
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int ptr = 0;
        // Compute X-sum for first window
        result[ptr++] = getXSum(freq, x);

                // Slide the window
        for (int i = k; i < n; i++) {
            int remove = nums[i - k];
            int add = nums[i];

            // Update frequency for removed element
            freq.put(remove, freq.get(remove) - 1);
            if (freq.get(remove) == 0) freq.remove(remove);

            // Update frequency for added element
            freq.put(add, freq.getOrDefault(add, 0) + 1);

            // Compute x-sum for current window
            result[ptr++] = getXSum(freq, x);
        }

        return result;
    }

    private int getXSum(Map<Integer, Integer> freq, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty() && count < x) {
            Pair p = pq.poll();
            sum += p.getNum() * p.getFreq();
            count++;
        }

        return sum;
    }

}