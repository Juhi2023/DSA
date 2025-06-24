class Tweet{
    int id;
    int time;

    public Tweet(int id, int time){
        this.id = id;
        this.time = time; 
    }
}

class User{
    int id;
    Set<Integer> following;
    LinkedList<Tweet> tweets;

    public User(int id){
        this.id = id;
        this.following = new HashSet<>();
        this.tweets = new LinkedList<>();
        follow(id);
    }

    public void follow(int id){
        following.add(id);
    }

    public void unfollow(int id){
        following.remove(id);
    }

    public void post(int id, int cnt){
        tweets.add(new Tweet(id, cnt));
    }
}

class Twitter {
    public static int cnt=0;
    HashMap<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
			User u = new User(userId);
			userMap.put(userId, u);
		}
        userMap.get(userId).post(tweetId, cnt++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return res;
        }
        Set<Integer> users = userMap.get(userId).following;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>((a,b)->(a.time-b.time));
        for(int x: users){
            if(userMap.get(x) !=null)
                for(Tweet t : userMap.get(x).tweets){
                    q.add(t);
                    if(q.size()>10){
                        q.poll();
                    }
                }
        }
        while(!q.isEmpty()){
            res.addFirst(q.poll().id);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
			User u = new User(followerId);
			userMap.put(followerId, u);
		}
		userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId)
			return;
		userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */