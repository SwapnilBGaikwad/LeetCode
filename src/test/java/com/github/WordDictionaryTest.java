package com.github;

import org.junit.Test;

public class WordDictionaryTest {
    @Test
    public void test() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        System.out.println(dictionary.search("pad"));
        System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("b.."));
    }
}