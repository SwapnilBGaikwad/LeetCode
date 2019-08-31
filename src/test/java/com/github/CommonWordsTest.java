package com.github;

import org.junit.Test;

public class CommonWordsTest {
    @Test
    public void test() {
        CommonWords commonWords = new CommonWords();
        String[] str = {"abc", "abcd", "jeff"};
        String mostCommonWord = commonWords.mostCommonWord("abc abc? abcd the jeff!", str);
        System.out.println(mostCommonWord);
    }
}