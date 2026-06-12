class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int m = cost.length;
        for(int i=2;i<m;i++){
            cost[i]+=Math.min(cost[i-2],cost[i-1]);
        }
        return Math.min(cost[m-1],cost[m-2]);
    }
}
