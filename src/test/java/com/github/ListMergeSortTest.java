package com.github;

import org.junit.Test;

public class ListMergeSortTest {
    @Test
    public void test() {
        ListMergeSort listMergeSort = new ListMergeSort();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode listNode = listMergeSort.sortList(head);
        while(listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}