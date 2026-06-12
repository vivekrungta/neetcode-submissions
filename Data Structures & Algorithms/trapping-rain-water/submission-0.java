class Solution {
    public int trap(int[] height) {
      int maxLeft=0;
      int maxRight=0;
      int res=0;
      int l=0;
      int h =height.length-1;
      while(l<h){
        if(height[l]<height[h]){
            if(height[l]>maxLeft){
                maxLeft=height[l];
            }else {
                res+=maxLeft-height[l];
            }
            l++;
        } else {
            if(height[h]>maxRight){
                maxRight=height[h];
            }else {
                res+=maxRight-height[h];
            }
            h--;
        }
      }
      return res;  
    }
}
