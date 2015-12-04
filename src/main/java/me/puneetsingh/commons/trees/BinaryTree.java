package me.puneetsingh.commons.trees;

public class BinaryTree<V> {
    V val = null;
    private BinaryTree<V> left = null;
    private BinaryTree<V> right = null;

    public BinaryTree(V v) {
        val = v;
    }

    public BinaryTree<V> makeLeft(V v) {
        left = new BinaryTree<V>(v);
        return left;
    }

    public BinaryTree<V> makeRight(V v) {
        right = new BinaryTree<V>(v);
        return right;
    }

    public BinaryTree<V> left() {
        return left;
    }

    public BinaryTree<V> right() {
        return right;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
