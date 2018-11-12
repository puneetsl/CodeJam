package me.puneetsingh.problems.leetcode;


import me.puneetsingh.utils.sort.Shuffle;
import me.puneetsingh.utils.commons.trees.BinarySearchTree;
import me.puneetsingh.utils.commons.trees.TreeNode;
import me.puneetsingh.utils.commons.trees.BTreePrinter;

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
        BinarySearchTree bst = BinarySearchTree.getRandomTree(10);
//        System.out.println(getNextGreater(5, bst.root));
        BTreePrinter.printNode(bst.root);
        List<Integer> lst = rightSideView(bst.root);
        for (Integer i : lst) {
            System.out.println(i);
        }
    }
}
