package com.github;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private int curr = 0;
    private DLL dll = new DLL();
    private Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node valueNode = map.get(key);
        if (valueNode == null) {
            return -1;
        }
        dll.remove(valueNode);
        dll.addFirst(valueNode);
        return valueNode.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            get(key);
            return;
        }
        node = new Node(value, key);
        map.put(key, node);
        dll.addFirst(node);
        curr++;
        if (curr <= capacity) {
            return;
        }
        map.remove(dll.getLastKey());
        dll.removeLast();
    }


    static class DLL {
        Node head, tail;

        void addFirst(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            node.next = head;
            head.prev = node;
            head = node;
        }

        void removeLast() {
            tail = tail.prev;
            tail.next = null;
        }

        void remove(Node node) {
            if(head == tail && head == node) {
                head = null;
                tail = null;
                return;
            }
            if (node == head) {
                head = head.next;
                head.prev = null;
                return;
            }
            if (node == tail) {
                tail = node.prev;
                tail.next = null;
                return;
            }
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        Integer getLastKey() {
            return tail.key;
        }
    }


    static class Node {
        int value, key;
        Node next, prev;

        Node(int value, int key) {
            this.value = value;
            this.key = key;
        }
    }
}
