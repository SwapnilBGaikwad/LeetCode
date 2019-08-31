package com.github;

public class ListMergeSort {
    ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode nextList = middle.next;
        middle.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(nextList);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newList;
        if (list1.val < list2.val) {
            newList = list1;
            list1 = list1.next;
        } else {
            newList = list2;
            list2 = list2.next;
        }
        ListNode head = newList;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newList.next = list1;
                list1 = list1.next;
            } else {
                newList.next = list2;
                list2 = list2.next;
            }
            newList = newList.next;
        }
        if (list1 == null) {
            newList.next = list2;
        } else {
            newList.next = list1;
        }
        return head;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head, middle = head;
        while (fast != null && fast.next != null) {
            middle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return middle;
    }
}
