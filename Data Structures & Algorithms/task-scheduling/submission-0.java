class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[]=new int[26];
        for(char task:tasks){
            count[task-'A']++;
        }
        Arrays.sort(count);
        int maxFreq = count[25];
        int chunk = maxFreq -1;
        int idleSpace = chunk*n;
        for(int i=24;i>=0;i--){
            idleSpace-=Math.min(count[i],chunk);
        }
        return idleSpace<=0?tasks.length:idleSpace+tasks.length;
    }
}
