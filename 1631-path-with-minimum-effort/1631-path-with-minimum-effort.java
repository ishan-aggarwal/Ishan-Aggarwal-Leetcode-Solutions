class Solution 
{
    int dx[] = {-1, 0, 0, 1};
    int dy[] = {0, 1, -1, 0};
    
    class node
    {
        int x , y;
        node(int x , int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public int minimumEffortPath(int[][] arr) 
    {
        int n = arr.length , m =  arr[0].length, x, y;
        int e[][] = new int[n][m];
        for(int a[] : e)
            Arrays.fill(a , Integer.MAX_VALUE);
        
        e[0][0] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>((a,b)-> e[a.x][a.y]-e[b.x][b.y]);
        pq.add(new node(0,0));
        node temp;
        
        while(!pq.isEmpty())
        {
            temp = pq.poll();
            
            for(int i=0 ; i<4 ; i++)
            {
                x = temp.x + dx[i];
                y = temp.y + dy[i];
                if(x>=0 && x<n && y>=0 && y<m)
                {
                    if(e[x][y]>Math.max(e[temp.x][temp.y], Math.abs(arr[x][y]-arr[temp.x][temp.y])))
                    {
                        e[x][y] = Math.max(e[temp.x][temp.y], Math.abs(arr[x][y]-arr[temp.x][temp.y]));
                        pq.offer(new node(x , y));
                    }
                    
                }
            }
        }
        return e[n-1][m-1];
    }
}