class Solution {
    public String minWindow(String s, String t) {
        int countS[] = new int[256];
        int countT[] = new int[256];
        int l = t.length();
        for(int i=0;i<l;i++){
            countT[t.charAt(i)]++;
        }
        int count=0;
        int start=0;
        int startIndex = -1;
        int min=Integer.MAX_VALUE;;
        for(int i=0;i<s.length();i++){
            countS[s.charAt(i)]++;
            if(countS[s.charAt(i)]<=countT[s.charAt(i)]) count++;
            if(count==l){
                while(countS[s.charAt(start)]>countT[s.charAt(start)]){
                    countS[s.charAt(start)]--;
                    start++;
                }
                if(min>i-start+1){
                    min=i-start+1;
                    startIndex=start;
                }
                
            }
        }
        return (startIndex==-1)? "" :s.substring(startIndex,startIndex+min);
    }
}
