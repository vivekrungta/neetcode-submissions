class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[256];
        Arrays.fill(index,-1);
        int start=0;
        int max =0;
        for(int i=0;i<s.length();i++){
            if(index[s.charAt(i)]>=start){
                start=index[s.charAt(i)]+1;
            }
            index[s.charAt(i)]=i;
            max=Math.max(max,i-start+1);
        }
        return max;
    }
}
