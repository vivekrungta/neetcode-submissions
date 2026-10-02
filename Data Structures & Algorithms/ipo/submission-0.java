class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> profitPQ = new  PriorityQueue<>(Collections.reverseOrder());
        int[][] profitCapital = new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            profitCapital[i]=new int[]{profits[i],capital[i]};
        }
        Arrays.sort(profitCapital,(a,b)->a[1]-b[1]);
        int i=0;
        
        while(k!=0){
            while(i<profits.length && w>=profitCapital[i][1]) {
                profitPQ.add(profitCapital[i][0]);
                i++;
            }
            if(profitPQ.isEmpty()) break;
            w+=profitPQ.poll();
            k--;
        }
        return w;
    }
}