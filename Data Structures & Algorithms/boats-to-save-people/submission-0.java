class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0;
        int h=people.length-1;
        int count=0;
        while(l<=h){
            if(people[l]+people[h]<=limit){
                l++;h--;
                count++;
            } else {
                h--;
                count++;
            }
        }
        return count;
    }
}