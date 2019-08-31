package com.github;

import org.junit.Test;

import java.util.List;

public class CommonCharInStringTest {
    @Test
    public void test() {
        String[] arr = {"bella", "label", "roller"};
        CommonCharInString commonCharInString = new CommonCharInString();
        List<String> list = commonCharInString.commonChars(arr);
        System.out.println(list);
    }
}