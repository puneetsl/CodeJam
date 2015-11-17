package me.puneetsingh.basics.misc;


import me.puneetsingh.commons.tree.BinarySearchTree;
import me.puneetsingh.commons.tree.TreeNode;

import java.util.Stack;

public class NextLargestInBST {
    static boolean b;
    BinarySearchTree bst = new BinarySearchTree();
    public static int getNextGreater(int num, TreeNode root)
    {
        return inOrder(num, root);
    }

    private static int inOrder(int num, TreeNode root)
    {
        if(root == null)
            return 0;
        int x;
        inOrder(num,root.left);
        if(b)
            return root.data;
        if(num==root.data)
            b=true;
        x = inOrder(num,root.right);
        return x;
    }
    private static int getNextGreaterLogN(int num, TreeNode root)
    {
        Stack<TreeNode> s = new Stack<TreeNode>();
        fillNodes(num, root, s);
        while(!s.empty())
        {
            TreeNode t = s.pop();
            if(t.right!=null)
            {
                return getLeftMost(t.right);
            }
        }
        return -1;
    }

    private static int getLeftMost(TreeNode t) {
        if(t.left==null)
            return t.data;
        else
            return getLeftMost(t.left);
    }

    private static void fillNodes(int num, TreeNode root, Stack<TreeNode> s) {
        if(root==null)
            return;

        s.add(root);
        if(root.data == num)
            return;
        if(num > root.data)
            fillNodes(num, root.right, s);
        else
            fillNodes(num, root.left, s);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Integer a[] = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            a[i] = i + 1;
        }
        Shuffle.randomize(a);

        for (int x: a)
        {
            bst.insert(x);
        }
        System.out.println(getNextGreaterLogN(101, bst.root));
    }
}
