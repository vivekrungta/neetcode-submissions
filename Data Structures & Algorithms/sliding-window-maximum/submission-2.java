class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int[] res = new int[nums.length-k+1];

        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]) dq.pollLast();
            dq.add(i);
            while(!dq.isEmpty() && dq.peek()<=i-k) dq.poll();
            if(i>=k-1){
                res[i-k+1]=nums[dq.peek()];
            }
        }
        return res;
    }
}
