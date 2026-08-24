class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        while(true){
            slow = calc(slow);
            fast=calc(calc(fast));
            if(slow==1) return true;
            if(slow==fast) break;
        }
        return false;
    }

    public int calc(int n){
        int res=0;
        while(n!=0){
            res+=(n%10)*(n%10);
            n=n/10;
        }
        return res;
    }
}
