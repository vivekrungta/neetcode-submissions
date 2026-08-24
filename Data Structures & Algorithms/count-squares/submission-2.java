class CountSquares {
    Map<String,Integer> countMap;
    List<int[]> points;

    public CountSquares() {
        countMap = new HashMap<>();
        points= new ArrayList<>();
    }


    public void add(int[] point) {
        points.add(point);
        String key = point[0]+"#"+point[1];
        countMap.put(key,countMap.getOrDefault(key,0)+1);
    }
    
    public int count(int[] point) {
        int sum=0;
        for(int kPoint[]:points){
            if(kPoint[0]==point[0] || kPoint[1]==point[1] || Math.abs(kPoint[0]-point[0])!=Math.abs(kPoint[1]-point[1])) continue;
            sum+=countMap.getOrDefault(point[0]+"#"+kPoint[1],0)*countMap.getOrDefault(kPoint[0]+"#"+point[1],0);
        }
        return sum;
    }
}
