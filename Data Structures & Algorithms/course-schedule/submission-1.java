class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> g[] = new List[numCourses];
        for(int i=0;i<numCourses;i++){
            g[i]=new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for(int[] prereq:prerequisites){
            g[prereq[1]].add(prereq[0]);
            indegree[prereq[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            count++;
            int n = q.poll();
            for(int child:g[n]){
                indegree[child]--;
                if(indegree[child]==0){
                q.add(child);
            }
            }
        }
        return count==numCourses;
    }
}
