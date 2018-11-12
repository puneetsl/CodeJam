package me.puneetsingh.problems.others.easy.misc;

import me.puneetsingh.utils.commons.linkedlist.SimpleLinkedList;

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
    private static SimpleLinkedList reverseLLRecursion(SimpleLinkedList head)
    {
        if(head.next==null)
            return head;
        SimpleLinkedList next = head.next;
        head.next = null;
        return reverseLLRecursion(next,head);
    }
    private static SimpleLinkedList reverseLLRecursion(SimpleLinkedList head, SimpleLinkedList prev)
    {
        if(head.next==null) {
            head.next = prev;
            return head;
        }
        SimpleLinkedList curr =  reverseLLRecursion(head.next, head);
        head.next = prev;
        return curr;
    }
    public static void main(String[] args) {
        SimpleLinkedList head = createLL();
        printLL(head);
        //head = reverseLL(head);
        head = reverseLLRecursion(head);
        printLL(head);
    }
}
