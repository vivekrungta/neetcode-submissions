class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(k==arr.length){  
            for(int a:arr) res.add(a);
            return res;
        }
        int closestPoint = binarySearch(arr,x);
        int l = closestPoint-1;
        int h = l+1;
        while(h-l-1<k){
            if(l==-1){
                h++;
            } else if(h==arr.length){
                l--;
            } else {
                if(Math.abs(x-arr[l])<=Math.abs(x-arr[h])){
                    l--;
                } else {
                    h++;
                }
            }
        }
        for(int i=l+1;i<h;i++){
            res.add(arr[i]);
        }
        return res;

    }
    private int binarySearch(int[] arr,int x){
        int l =0;
        int h=arr.length-1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(arr[m]==x) return m;
            if(arr[m]<x) l=m+1;
            else h =m-1;
        }
        return l;
    }



}