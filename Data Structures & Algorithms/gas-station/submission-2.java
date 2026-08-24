class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr_cost =0;
        int total_cost =0;
        int start =0;
        for(int i=0;i<gas.length;i++){
            curr_cost+=gas[i]-cost[i];
            total_cost+=gas[i]-cost[i];
            if(curr_cost<0){
                start=i+1;
                curr_cost=0;
            }
        }
        return total_cost>=0?start:-1;
    }
}
