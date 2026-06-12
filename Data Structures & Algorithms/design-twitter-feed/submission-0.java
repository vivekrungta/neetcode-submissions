class Twitter {
    Map<Integer,Set<Integer>> followMap;
    Map<Integer,List<Tweet>> tweetMap;
    int feedMaxNum;
    public Twitter() {
        feedMaxNum = 10;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    class Tweet {
        int tweetId;
        int timeStamp;
        Tweet(int tw,int ts){
            tweetId=tw;
            timeStamp=ts;
        }

    }
    int timestamp;
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);
        tweetMap.get(userId).add(0,new Tweet(tweetId,timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feedHeap = new PriorityQueue<>((t1,  t2)-> {
            return t1.timeStamp - t2.timeStamp;
        }
        );
        Set<Integer> myFollowees = followMap.get(userId);
        if(myFollowees != null){
            for(int followeeId : myFollowees){
                List<Tweet> followeeTweets = tweetMap.get(followeeId);
                if(followeeTweets == null) continue;
                for(Tweet t : followeeTweets){
                    if(feedHeap.size() < feedMaxNum) feedHeap.add(t);
                    else{
                        if(t.timeStamp <= feedHeap.peek().timeStamp) break;
                        else{
                            feedHeap.add(t);
                            feedHeap.poll(); //remove the oldest tweet
                        }
                    }
                }
            }
        }
        List<Integer> myFeed = new LinkedList<>();
        while(!feedHeap.isEmpty()){
            myFeed.add(0, feedHeap.poll().tweetId);
        }
        return myFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
