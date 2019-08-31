package com.github;

import java.util.*;
import java.util.stream.Collectors;

public class Twitter {
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Set<Twit>> twitMap;
    private int orderId = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        twitMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Set<Twit> set = twitMap.get(userId);
        if (set == null) {
            set = new HashSet<>();
            twitMap.put(userId, set);
        }
        orderId++;
        set.add(new Twit(tweetId, orderId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> users = followMap.get(userId);
        if (users == null) {
            users = new HashSet<>();
            followMap.put(userId, users);
        }
        users.add(userId);
        List<Twit> list = new LinkedList<>();
        for (Integer id : users) {
            list.addAll(twitMap.get(id));
        }

        return list.stream().sorted().limit(10).map(a -> a.id).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> users = followMap.get(followerId);
        if (users == null) {
            users = new HashSet<>();
            followMap.put(followerId, users);
        }
        users.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> users = followMap.get(followerId);
        if (users == null) {
            return;
        }
        users.remove(followeeId);
    }

    class Twit implements Comparable<Twit> {
        int id;
        int orderId;

        Twit(int id, int orderId) {
            this.id = id;
            this.orderId = orderId;
        }

        @Override
        public int compareTo(Twit o) {
            return o.orderId - orderId;
        }
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