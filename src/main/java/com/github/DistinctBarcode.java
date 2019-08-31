package com.github;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistinctBarcode {
    public int[] rearrangeBarcodes(int[] arr) {
        Map<Integer, Node> map = new HashMap<>();
        for (int value : arr) {
            Node node = map.get(value);
            if (node == null) {
                node = new Node(0, value);
                map.put(value, node);
            }
            node.count++;
        }
        PriorityQueue<Node> heap = new PriorityQueue<>(map.values());
        int i = 0;
        Node node1 = heap.remove();
        Node node2 = heap.remove();
        while (!heap.isEmpty()) {
            if (node1.count == 0) {
                node1 = heap.remove();
            } else {
                node2 = heap.remove();
            }
            while (node1.count > 0 && node2.count > 0) {
                if (i == 0) {
                    arr[i] = node1.no;
                    node1.count--;
                } else if (arr[i - 1] == node1.no) {
                    arr[i] = node2.no;
                    node2.count--;
                } else {
                    arr[i] = node1.no;
                    node1.count--;
                }
                i++;
            }
        }
        return arr;
    }

    static class Node implements Comparable<Node> {
        int count, no;

        Node(int count, int no) {
            this.count = count;
            this.no = no;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - count;
        }
    }
}
