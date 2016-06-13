package me.puneetsingh.problems.others.easy.misc;


import me.puneetsingh.utils.sort.Shuffle;
import me.puneetsingh.utils.commons.trees.BinarySearchTree;
import me.puneetsingh.utils.commons.trees.TreeNode;
import me.puneetsingh.utils.commons.trees.BTreePrinter;

import java.util.Stack;

public class NextLargestInBST {

    public static int getNextGreater(int num, TreeNode root) {
        return inOrder(num, root);

    }

    private static int inOrder(int num, TreeNode root) {
        int x = -1;
        if (root.left != null && x==-1)
            x = inOrder(num, root.left);
        if (root.data > num && x==-1)
            return root.data;
        if (root.right != null && x==-1)
            x = inOrder(num, root.right);
        return x;
    }

    private static int getNextGreaterLogN(int num, TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        fillNodes(num, root, s);
        TreeNode t = s.pop();
        if(t.right != null)
            return getLeftMost(t.right);
        else {
            while (s.peek().data < num)
                s.pop();
            return s.pop().data;
        }
    }

    private static int getLeftMost(TreeNode t) {
        if (t.left == null)
            return t.data;
        else
            return getLeftMost(t.left);
    }

    private static void fillNodes(int num, TreeNode root, Stack<TreeNode> s) {
        if (root == null)
            return;

        s.add(root);
        if (root.data == num)
            return;
        if (num > root.data)
            fillNodes(num, root.right, s);
        else
            fillNodes(num, root.left, s);
    }

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
//        System.out.println(getNextGreater(5, bst.root));
        System.out.println(getNextGreaterLogN(7, bst.root));
        BTreePrinter.printNode(bst.root);
    }
}

