package me.puneetsingh.problems.others.easy.list;

import me.puneetsingh.utils.commons.linkedlist.SimpleLinkedList;

public class SwapAlternate {


    public static void main(String[] args) {
        SimpleLinkedList head = SimpleLinkedList.createLL(11);
        SimpleLinkedList.printLL(head);
        //head = reverseLL(head);
        head = swapAlternateNR(head);
        SimpleLinkedList.printLL(head);
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
