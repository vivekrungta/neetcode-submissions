class Solution {
    public String longestPalindrome(String s) {
        char[] ca = s.toCharArray();
        int res =1;
        int start =0;
        for(int i=0;i<ca.length;i++){
            int l=i;
            int h=i+1;
            while(l>=0 && h<ca.length && ca[l]==ca[h]) {
                l--;
                h++;
            }
            if(res<h-l-1) {
                res=h-l-1;
                start=l+1;
            }
            res=Math.max(res,h-l-1);
            l=i-1;
            h=i+1;
            while(l>=0 && h<ca.length && ca[l]==ca[h]) {
                l--;
                h++;
            }
            if(res<h-l-1) {
                res=h-l-1;
                start=l+1;
            }

        }
        return s.substring(start,start+res);
    }
}
