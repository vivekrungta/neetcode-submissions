class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] mult = new int[m+n-1];
        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++)
            mult[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        }
        for(int i=m+n-2;i>0;i--){
            mult[i-1]+=mult[i]/10;
            mult[i]=mult[i]%10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m+n-1;i++){
            sb.append(mult[i]);
        }
        return sb.toString();
    }
}
