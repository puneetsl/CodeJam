package me.puneetsingh.basics.misc;


import me.puneetsingh.commons.tree.BinarySearchTree;
import me.puneetsingh.commons.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        while (!s.empty()) {
            TreeNode t = s.pop();
            if (t.right != null && t.data >= num) {
                int i = getLeftMost(t.right);
                if (t.data > num)
                    return i > t.data ? t.data : i;
                else
                    return i;
            } else if (t.right == null && t.data > num) {
                return t.data;
            }
        }
        return -1;
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
        System.out.println(getNextGreater(5, bst.root));
        System.out.println(getNextGreaterLogN(1, bst.root));
        BTreePrinter.printNode(bst.root);
    }
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(TreeNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}