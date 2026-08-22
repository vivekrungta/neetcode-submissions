class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int h = heights.length-1;
        int max =0;
        while(l<h){
            if(heights[l]<heights[h]) {
                max=Math.max(max,(h-l)*heights[l]);
                l++;
            } else {
                max=Math.max(max,(h-l)*heights[h]);
                h--;
            }
        }
        return max;
    }
}
