package me.puneetsingh.websites.leetcode;


import me.puneetsingh.commons.algos.Shuffle;
import me.puneetsingh.commons.trees.BinarySearchTree;
import me.puneetsingh.commons.trees.TreeNode;
import me.puneetsingh.commons.trees.BTreePrinter;

import java.util.Stack;

public class InOrderNoRecursion {
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
        inOrderNoRec(bst);
        BTreePrinter.printNode(bst.root);
    }


    private static void inOrderNoRec(BinarySearchTree bst) {
        Stack<TreeNode> order = new Stack<>();
        order.push(bst.root);
        while(order.peek().left!=null)
            order.push(order.peek().left);
        TreeNode n = null;
        while (!order.isEmpty())
        {
            n = order.pop();
            System.out.println(n.data+" ");
            if(n.right!=null) {
                order.push(n.right);
                while (order.peek().left != null)
                    order.push(order.peek().left);
            }
        }
    }
}
