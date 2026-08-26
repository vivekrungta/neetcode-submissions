class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m+n;
        if(len%2==0){
            return (double)(findKthItem(nums1,nums2,0,0,len/2)+findKthItem(nums1,nums2,0,0,len/2+1))*0.5;
        } else {
            return findKthItem(nums1,nums2,0,0,len/2+1);
        }
    }

    public int findKthItem(int nums1[],int nums2[],int startA,int startB,int k){
        if(startA==nums1.length) return nums2[startB+k-1];
        if(startB==nums2.length) return nums1[startA+k-1];
        if(k==1) return Math.min(nums1[startA],nums2[startB]);
        int aMid=(startA+k/2-1)<nums1.length?nums1[startA+k/2-1]:Integer.MAX_VALUE;
        int bMid=(startB+k/2-1)<nums2.length?nums2[startB+k/2-1]:Integer.MAX_VALUE;
        if(aMid<bMid) return findKthItem(nums1,nums2,startA+k/2,startB,k-k/2);
        else return findKthItem(nums1,nums2,startA,startB+k/2,k-k/2);
    }
}
