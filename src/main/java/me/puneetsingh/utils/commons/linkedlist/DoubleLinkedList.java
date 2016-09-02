package me.puneetsingh.utils.commons.linkedlist;

public class DoubleLinkedList {
    public Integer val = 0;
    public DoubleLinkedList next = null;
    public DoubleLinkedList prev = null;

    public DoubleLinkedList(int val) {
        this.val = val;
    }
    public static DoubleLinkedList printLL(DoubleLinkedList node) {
        if(node!=null) {
            while (node.next != null) {
                System.out.print(node.val + "->");
                node = node.next;
            }
            System.out.println(node.val);
            return node;
        }
        else
        {
            System.err.println("Empty/Err Linked List");
            return null;
        }
    }

    public static DoubleLinkedList printLLR(DoubleLinkedList node) {
        if(node!=null) {
            while (node.prev != null) {
                System.out.print(node.val + "->");
                node = node.prev;
            }
            System.out.println(node.val);
            return node;
        }
        else
        {
            System.err.println("Empty/Err Linked List");
            return null;
        }
    }
}