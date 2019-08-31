package com.github;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node('R');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            Node child = curr.childs.get(ch);
            if (child == null) {
                child = new Node(ch);
                curr.childs.put(ch, child);
            }
            curr = child;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            Node child = curr.childs.get(ch);
            if (child == null) {
                return false;
            }
            curr = child;
        }
        return curr.isCompleted();
    }

    class Node {
        char ch;
        Map<Character, Node> childs = new HashMap<>();

        Node(char ch) {
            this.ch = ch;
        }

        boolean isCompleted() {
            return childs.isEmpty();
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */