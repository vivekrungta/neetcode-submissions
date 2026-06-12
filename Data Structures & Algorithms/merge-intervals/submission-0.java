class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(end<intervals[i][0]){
                res.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            } else {
                end = Math.max(end,intervals[i][1]);
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}
