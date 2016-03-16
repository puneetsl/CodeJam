package me.puneetsingh.random.basics.Lists;

import me.puneetsingh.commons.linkedlist.SimpleLinkedList;

public class SwapAlternate {
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
        for (int i = 2; i < 4; i++) {
            node.next = new SimpleLinkedList(i);
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SimpleLinkedList head = createLL();
        printLL(head);
        head = swapAlternateNR(head);
        printLL(head);
    }

    private static SimpleLinkedList swapAlternateNR(SimpleLinkedList head) {
        if (head == null)
            return null;
        SimpleLinkedList prev = null;
        SimpleLinkedList curr = head;
        SimpleLinkedList next = head.next;
        SimpleLinkedList ret = head.next;

        while (next != null) {
            if (prev != null) {
                prev.next = next;
            }
            SimpleLinkedList temp = next.next;
            next.next = curr;
            curr.next = temp;
            if (temp != null) {
                prev = curr;
                curr = curr.next;
                next = curr.next;
            } else {
                break;
            }
        }
        return ret == null ? head : ret;
    }

    private static SimpleLinkedList swapAlternateR(SimpleLinkedList head) {
        return swapAlternateR(null, head, head.next);
    }

    private static SimpleLinkedList swapAlternateR(SimpleLinkedList prev, SimpleLinkedList curr, SimpleLinkedList next) {
        if (next != null) {
            if (prev != null) {
                prev.next = next;
            }
            SimpleLinkedList temp = next.next;
            next.next = curr;
            curr.next = temp;
            if (temp != null)
                swapAlternateR(curr, curr.next, curr.next.next);
        }
        return next == null ? curr : next;
    }
}
