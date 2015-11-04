package me.puneetsingh.basics.misc;

import me.puneetsingh.commons.linkedlist.SimpleLinkedList;

public class ReverseLinkedList {
    private static void printLL(SimpleLinkedList node) {
        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println(node.val);
    }

    private static SimpleLinkedList createLL() {
        SimpleLinkedList head = new SimpleLinkedList(1);
        SimpleLinkedList node = head;
        for (int i = 2; i < 11; i++) {
            node.next = new SimpleLinkedList(i);
            node = node.next;
        }
        return head;
    }

    private static SimpleLinkedList reverseLL(SimpleLinkedList head) {
        SimpleLinkedList c = head.next;//current
        SimpleLinkedList p = head;//previous
        head.next = null;
        SimpleLinkedList n;//next
        while (c.next != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        c.next = p;
        return c;
    }

    public static void main(String[] args) {
        SimpleLinkedList head = createLL();
        printLL(head);
        head = reverseLL(head);
        printLL(head);
    }
}
