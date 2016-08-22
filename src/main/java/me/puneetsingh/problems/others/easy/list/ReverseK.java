package me.puneetsingh.problems.others.easy.list;

import me.puneetsingh.utils.commons.linkedlist.SimpleLinkedList;

public class ReverseK {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SimpleLinkedList head = SimpleLinkedList.createLL(i);
            SimpleLinkedList.printLL(head);
            head = reverseK(head, 3);
            SimpleLinkedList.printLL(head);
            System.out.println();
        }

    }

    private static SimpleLinkedList reverseK(SimpleLinkedList head, int k) {
        SimpleLinkedList cur = head;
        int i = 1;
        SimpleLinkedList s = null, e = null, ps = null;
        while (cur.next != null) {
            if (i % k == 1) {
                s = cur;
            }
            if (i % k == 0) {
                e = cur;
            }
            cur = cur.next;
            if (i % k == 0) {
                e.next = ps;
                ps = s;
            }
            i++;
        }
        if (i % k == 1) {
            s = cur;
        }
        if(i-1%k!=0) {
            cur.next = ps;

        }
        return s;
    }
}
