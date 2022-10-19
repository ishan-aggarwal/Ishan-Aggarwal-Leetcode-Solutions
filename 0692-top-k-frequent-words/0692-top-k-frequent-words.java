class Solution {
    public List < String > topKFrequent(String[] words, int k) {
        Map < String, Integer > map = new HashMap < > ();
        List < String > ans = new LinkedList < > ();

        for (int i = 0; i < words.length; i++) {

            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i]) + 1);
            else
                map.put(words[i], 1);
        }

        PriorityQueue < String > pq = new PriorityQueue < > ((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b)); //-1 means no swap
        System.out.println(pq);

        for (String s: map.keySet()) {
            pq.offer(s);
            if (pq.size() > k)
                pq.poll();
        }
        while (!pq.isEmpty())
            ans.add(0, pq.poll());

        return ans;
    }
}