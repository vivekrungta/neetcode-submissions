class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;


    public MedianFinder() {
        left= new PriorityQueue<>(Collections.reverseOrder());
        right= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty()||left.peek()>num) left.add(num);
        else right.add(num);
        rebalance();
    }
    
    public double findMedian() {
        if(left.size()==right.size()) return (left.peek()+right.peek())*0.5;
        else return (double)left.peek();
    }

    private void rebalance(){
        if(left.size()>right.size()+1) right.add(left.poll());
        else if (right.size()>left.size()) left.add(right.poll());
    }
}
