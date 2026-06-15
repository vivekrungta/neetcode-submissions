class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l=0;int h= n-1;
        while(l<h){
            if(s.charAt(l)!=s.charAt(h)) {
                break;
            }
            l++;
            h--;
        }
        if(l>=h) return true;
        return isPalindrome(s,l,h-1) || isPalindrome(s,l+1,h);
    }

    public boolean isPalindrome(String s,int l,int h) {
        while(l<h){
            if(s.charAt(l)!=s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}