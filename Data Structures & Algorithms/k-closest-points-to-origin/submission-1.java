class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        int i=0;
        for(int[] point:points){
            pq.add(new int[]{i++,dist(point)});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int res[][]= new int[k][2];
        i=0;
        while(!pq.isEmpty()){
            res[i++]=points[pq.poll()[0]];
        }        
        return res;

    }

    public int dist(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
}
