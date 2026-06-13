class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[]=new int[26];
        for(char task:tasks){
            count[task-'A']++;
        }
        Arrays.sort(count);
        int maxFreq = count[25];
        int slot = maxFreq -1;
        int idleSpace = slot*n;
        for(int i=24;i>=0;i--){
            idleSpace-=Math.min(count[i],slot);
        }
        return idleSpace<=0?tasks.length:idleSpace+tasks.length;
    }
}
