package com.github;

import org.junit.Test;

public class TwitterTest {
    @Test
    public void test() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.getNewsFeed(1);
    }
}