package me.puneetsingh.Runners;

import me.puneetsingh.commons.trees.BinaryTree;

public class TryBTrees {
    public static void main(String[] args) {
        BinaryTree<Integer> b = new BinaryTree<Integer>(5);
        BinaryTree<Integer> c;
        c = b.makeLeft(4);
        c = c.makeLeft(2);
        c = b.left().makeRight(7);
        c = b.makeRight(10);
        c = c.makeLeft(12);
        c = b.right().makeRight(17);
        System.out.println(b+", "+b.left()+", "+b.right());

    }
}
