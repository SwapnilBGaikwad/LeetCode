package com.github;

import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character,Letter> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Letter letter = map.get(ch);
            if(letter == null) {
                map.put(ch, new Letter(ch));
            } else {
                letter.increament();
            }
        }
        LinkedList<Letter> list = new LinkedList<>(map.values());
        Collections.sort(list);
        StringBuilder builder = new StringBuilder();
        for(Letter l : list) {
            builder.append(l.toString());
        }
        return  builder.toString();
    }

    class Letter implements Comparable<Letter> {
        int count;
        char ch;

        Letter(char ch) {
            this.ch = ch;
            count = 1;
        }

        void increament() {
            count++;
        }

        @Override
        public int compareTo(Letter o) {
            return o.count - count;
        }

        @Override
        public String toString() {
            char[] arr = new char[count];
            Arrays.fill(arr, ch);
            return new String(arr);
        }
    }
}