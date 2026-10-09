/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->a.start-b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int room=0;
        for(Interval interval:intervals){
            pq.add(interval.end);
            if(interval.start<pq.peek()){
                room++;
            } else {
                pq.poll();
            }
        }
        return room;
    }
}
