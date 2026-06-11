class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean found = false;
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        for(int interval[]:intervals) {
            if(found || interval[1]<start){
                res.add(interval);
            } else if (end<interval[0]) {
                res.add(new int[]{start,end});
                res.add(interval);
                found=true;
            } else {
                start = Math.min(interval[0],start);
                end = Math.max(interval[1],end);
            }
        }
        if(!found) res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}
