class Solution {
    public void reverseString(char[] s) {
        int l=0;
        int h=s.length-1;
        while(l<h){
            char tmp=s[l];
            s[l]=s[h];
            s[h]=tmp;
            l++;
            h--;
        }
    }
}