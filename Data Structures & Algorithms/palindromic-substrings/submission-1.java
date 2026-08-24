class Solution {
    public int countSubstrings(String s) {
        char[] ca = s.toCharArray();
        int res =ca.length;
        for(int i=0;i<ca.length;i++){
            int l=i;
            int h=i+1;
            while(l>=0 && h<ca.length && ca[l]==ca[h]) {
                res++;
                l--;
                h++;
            }
            l=i-1;
            h=i+1;
            while(l>=0 && h<ca.length && ca[l]==ca[h]) {
                res++;
                l--;
                h++;
            }

        }
        return res;
    }
}
