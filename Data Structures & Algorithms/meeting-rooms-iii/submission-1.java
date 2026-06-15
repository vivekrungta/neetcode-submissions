class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> usedRooms = new PriorityQueue<>((a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        PriorityQueue<Integer> unUsedRooms = new PriorityQueue<>();
        Arrays.sort(meetings,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        int[] rooms = new int[n];
        for(int i=0;i<n;i++){
            unUsedRooms.add(i);
        }
        
        for(int i=0;i<meetings.length;i++){
            while(!usedRooms.isEmpty() && usedRooms.peek()[0]<=meetings[i][0]){
                unUsedRooms.add(usedRooms.poll()[1]);
            }
            if(!unUsedRooms.isEmpty()){
                int room = unUsedRooms.poll();
                rooms[room]++;
                usedRooms.add(new int[]{meetings[i][1],room});
            } else {
                int[] usedRoom = usedRooms.poll();
                rooms[usedRoom[1]]++;
                usedRooms.add(new int[]{usedRoom[0]+meetings[i][1]-meetings[i][0],usedRoom[1]});
            }
        }
        int max=0;
        int i=0;
        int index=0;
        for(int room:rooms){
            if(max<room){
                max=room;
                index=i;
            }
            i++;
        }
        return index;
    }
}