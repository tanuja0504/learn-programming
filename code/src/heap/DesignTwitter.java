package heap;

import java.util.*;

public class DesignTwitter {

    class TweetComparator implements Comparator<Tweet> {

        @Override
        public int compare(Tweet o1, Tweet o2) {
            return Integer.compare(o1.count, o2.count);
        }
    }

    class Tweet {
        int count;
        int id;

        Tweet(int count, int id) {
            this.count = count;
            this.id = id;
        }
    }

    Map<Integer, List<Integer>> followers;
    Map<Integer, PriorityQueue<Tweet>> tweets;
    static int count = 0;

    public DesignTwitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {

        count++;
        Tweet t = new Tweet(count, tweetId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>(new TweetComparator());
        if (tweets.containsKey(userId)) {
            pq = tweets.get(userId);
        }

        if (pq.size() >= 10) {
            pq.poll();
        }
        pq.offer(t);
        tweets.put(userId, pq);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>(new TweetComparator().reversed());


        if (followers.containsKey(userId)) {
            List<Integer> temp = followers.get(userId);
            for (int followee : temp) {
                if (tweets.containsKey(followee)) {
                    PriorityQueue<Tweet> tweet = new PriorityQueue<>(tweets.get(followee));
                    while (!tweet.isEmpty()) {
                        pq.offer(tweet.poll());
                    }
                }
            }
        }

        if (tweets.containsKey(userId)) {
            PriorityQueue<Tweet> l = new PriorityQueue<>(tweets.get(userId));
            while (!l.isEmpty()) {
                pq.offer(l.poll());
            }
        }
        while (!pq.isEmpty()) {
            feed.add(pq.poll().id);
            if (feed.size() == 10) {
                break;
            }
        }

        return feed;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        List<Integer> l = new ArrayList<>();
        if (followers.containsKey(followerId)) {
            l = followers.get(followerId);
        }
        if (!l.contains(followeeId)) {
            l.add(followeeId);
            followers.putIfAbsent(followerId, l);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> l = new ArrayList<>();
        if (followers.containsKey(followerId)) {
            l = followers.get(followerId);
        }
        int getIndex = l.indexOf(followeeId);
        l.remove(getIndex);
        followers.put(followerId, l);
    }

    public static void main(String[] args) {
        DesignTwitter obj = new DesignTwitter();
        obj.postTweet(1, 5);
        List<Integer> feed = obj.getNewsFeed(1);
        System.out.println(feed);

        obj.follow(1, 2);
        obj.postTweet(2, 6);
        List<Integer> feed1 = obj.getNewsFeed(1);
        System.out.println(feed1);

        obj.unfollow(1, 2);
        List<Integer> feed2 = obj.getNewsFeed(1);
        System.out.println(feed2);

        DesignTwitter obj2 = new DesignTwitter();
        obj2.follow(1, 5);
        List<Integer> feed3 = obj2.getNewsFeed(1);
        System.out.println(feed3);

        DesignTwitter obj3 = new DesignTwitter();
        obj3.postTweet(2, 5);
        obj3.follow(1, 2);
        List<Integer> feed4 = obj2.getNewsFeed(1);
        System.out.println(feed3);
    }
}
