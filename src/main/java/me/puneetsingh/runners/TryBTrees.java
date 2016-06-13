package me.puneetsingh.runners;

import me.puneetsingh.utils.commons.trees.BTreePrinter;
import me.puneetsingh.utils.commons.trees.BinarySearchTree;

public class TryBTrees {
    public static void main(String[] args) {
        BinarySearchTree bst = BinarySearchTree.getRandomTree(10);
        BTreePrinter.printNode(bst.root);
    }
}
