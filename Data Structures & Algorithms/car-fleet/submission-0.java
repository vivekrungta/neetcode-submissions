class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Double> mp = new TreeMap<>();
        for(int i=0;i<speed.length;i++){
            mp.put((target-position[i]),(double)(target-position[i])/speed[i]);
        }
        double curr=0.0;
        int res=0;
        for(double time:mp.values()){
            if(time>curr){
                curr=time;
                res++;
            }
        }
        return res;
    }
}
