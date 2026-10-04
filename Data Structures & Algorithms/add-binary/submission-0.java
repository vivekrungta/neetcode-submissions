class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry=0;
        int i=a.length()-1;
        int j = b.length()-1;
        while(i>=0 || j>=0){
            carry+= i>=0?a.charAt(i)-'0':0;
            carry+= j>=0?b.charAt(j)-'0':0;
            sb.append(carry%2);
            carry=carry/2;
            i--;
            j--;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}