class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int count1[] = new int[26];
        int count2[] = new int[26];
        if(s1.length()>s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        if(compare(count1,count2)) return true;
        for(int i=s1.length();i<s2.length();i++){
            count2[s2.charAt(i)-'a']++;
            count2[s2.charAt(i-s1.length())-'a']--;
            if(compare(count1,count2)) return true;
        }
        return false;
    }

    public boolean compare(int[] a,int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}
