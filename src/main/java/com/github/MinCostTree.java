package com.github;

public class MinCostTree {
    public int getCost(int[] arr) {
        MyList myList = new MyList();
        for (int no : arr) {
            myList.add(no);
        }
        int cost = 0;
        while (myList.size() > 2) {
            Node head = myList.head;
            int minProduct = Integer.MAX_VALUE;
            Node minNode = head;
            while (head.next != null) {
                int product = head.data * head.next.data;
                if (product < minProduct) {
                    minNode = head;
                    minProduct = product;
                }
                head = head.next;
            }
            myList.remove(minNode);
            cost += minProduct;
        }
        return cost + (myList.head.data * myList.head.next.data);
    }

    class MyList {
        private Node head, tail;
        private int size = 0;

        void add(int data) {
            size++;
            Node node = new Node(data);
            if (head == null) {
                head = node;
                tail = head;
                return;
            }
            tail.next = node;
            tail = node;
        }

        void remove(Node node) {
            if (node.data < node.next.data) {
                node.data = node.next.data;
            }
            node.next = node.next.next;
            size--;
        }

        int size() {
            return size;
        }
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
