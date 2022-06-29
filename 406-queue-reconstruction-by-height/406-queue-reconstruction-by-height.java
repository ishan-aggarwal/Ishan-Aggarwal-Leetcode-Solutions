class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1,o2)->((o1[0]==o2[0])?(o1[1]-o2[1]):(o2[0]-o1[0])));
        List<int[]> arr=new ArrayList<int[]>();
        for(int p[]:people) arr.add(p[1],p);
        return arr.toArray(new int[people.length][2]);
    }
}