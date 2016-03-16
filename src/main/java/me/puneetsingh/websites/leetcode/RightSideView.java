package me.puneetsingh.websites.leetcode;


import me.puneetsingh.commons.algos.Shuffle;
import me.puneetsingh.commons.trees.BinarySearchTree;
import me.puneetsingh.commons.trees.TreeNode;
import me.puneetsingh.commons.trees.BTreePrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {
    List<Integer> rightVals = new ArrayList<>();

    public static List<Integer> rightSideView(TreeNode root) {
        HashMap<TreeNode, Integer> hm = new HashMap<TreeNode, Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> lst = new ArrayList<>();
        queue.add(root);
        int level = 1;
        hm.put(root, level);
        int lastLevel = 0;
        while (!queue.isEmpty()) {
            TreeNode t = queue.removeFirst();
            if (hm.containsKey(t) && lastLevel + 1 == hm.get(t)) {
                lastLevel++;
                lst.add(t.data);
            }
            if (t.right != null) {
                queue.addLast(t.right);
                hm.put(t.right, hm.get(t) + 1);
            }
            if (t.left != null) {
                queue.addLast(t.left);
                hm.put(t.left, hm.get(t) + 1);
            }
        }
        return lst;
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
        BTreePrinter.printNode(bst.root);
        List<Integer> lst = rightSideView(bst.root);
        for (Integer i : lst) {
            System.out.println(i);
        }
    }
}
