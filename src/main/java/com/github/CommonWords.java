package com.github;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class CommonWords {
    public String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = Character.toLowerCase(paragraph.charAt(i));
            if (ch >= 'a' && ch <= 'z' || ch == ' ') {
                builder.append(ch);
            } else if (ch == ',') {
                builder.append(' ');
            }
        }
        String para = builder.toString();
        String[] arr = para.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(String str : arr) {
            String key = str.toLowerCase().trim();
            if (key.isEmpty()) {
                continue;
            }
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for(String str : banned) {
            map.remove(str.toLowerCase());
        }
        Set<String> set = map.keySet();
        String res = null;
        int count = 0;
        for(String str : set) {
            if(map.get(str) > count) {
                count = map.get(str);
                res = str;
            }
        }
        return res;
    }
}