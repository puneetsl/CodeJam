package me.puneetsingh.utils.commons.linkedlist;

public class SimpleLinkedList {
    public Integer val = 0;
    public SimpleLinkedList next = null;

    public SimpleLinkedList(int val) {
        this.val = val;
    }
    public static void printLL(SimpleLinkedList node) {
        if(node!=null) {
            while (node.next != null) {
                System.out.print(node.val + "->");
                node = node.next;
            }
            System.out.println(node.val);
        }
        else
        {
            System.err.println("Empty/Err Linked List");
        }
    }

    public static SimpleLinkedList createLL(int size) {
        SimpleLinkedList head = new SimpleLinkedList(1);
        SimpleLinkedList node = head;
        for (int i = 2; i <= size; i++) {
            node.next = new SimpleLinkedList(i);
            node = node.next;
        }
        return head;
    }
}