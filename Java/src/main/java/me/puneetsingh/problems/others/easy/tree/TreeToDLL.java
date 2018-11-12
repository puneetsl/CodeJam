package me.puneetsingh.problems.others.easy.tree;

import me.puneetsingh.utils.commons.linkedlist.DoubleLinkedList;
import me.puneetsingh.utils.commons.trees.BTreePrinter;
import me.puneetsingh.utils.commons.trees.BinarySearchTree;
import me.puneetsingh.utils.commons.trees.TreeNode;
import me.puneetsingh.utils.sort.Shuffle;

public class TreeToDLL {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Integer a[] = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i + 1;
        }
        Shuffle.randomize(a);

        for (int x : a) {
            bst.insert(x);
        }
        BTreePrinter.printNode(bst.root);
        if(bst.root!=null) {
            DoubleLinkedList dll = new DoubleLinkedList(0);
            createdll(bst.root, dll, null);
            TreeNode tll = createdTll(bst.root);
            ///////////////////////////
            dll=dll.next;
            dll.prev = null;
            DoubleLinkedList f = DoubleLinkedList.printLL(dll);
            DoubleLinkedList.printLLR(f);
            ///////////////////////////
            printTLLR(printTLL(tll));
        }


    }

    //Using extra linkedList
    private static DoubleLinkedList createdll(TreeNode root, DoubleLinkedList c, DoubleLinkedList p) {
        if(root!=null)
        {
            c = createdll(root.left, c, p);
            c.next = new DoubleLinkedList(root.data);
            p = c;
            c = c.next;
            c.prev = p;
            c = createdll(root.right, c, p);
        }
        return c;
    }
    private static TreeNode createdTll(TreeNode root) {
        TreeNode tll = new TreeNode(0);
        createdTll(root, tll , null);
        tll=tll.right;
        tll.left = null;
        return tll;
    }
    //using tree, No extra memory
    private static TreeNode createdTll(TreeNode root, TreeNode c, TreeNode p) {
        if(root!=null)
        {
            c = createdTll(root.left, c, p);
            c.right = root;
            p = c;
            c = c.right;
            c.left = p;
            c = createdTll(root.right, c, p);
        }
        return c;
    }
    public static TreeNode printTLL(TreeNode node) {
        if(node!=null) {
            while (node.right != null) {
                System.out.print(node.data + "->");
                node = node.right;
            }
            System.out.println(node.data);
            return node;
        }
        else
        {
            System.err.println("Empty/Err Linked List");
            return null;
        }
    }

    public static TreeNode printTLLR(TreeNode node) {
        if(node!=null) {
            while (node.left != null) {
                System.out.print(node.data + "->");
                node = node.left;
            }
            System.out.println(node.data);
            return node;
        }
        else
        {
            System.err.println("Empty/Err Linked List");
            return null;
        }
    }
}
