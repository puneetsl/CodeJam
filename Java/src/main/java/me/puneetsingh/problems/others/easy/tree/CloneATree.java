package me.puneetsingh.problems.others.easy.tree;

import me.puneetsingh.utils.commons.trees.BTreePrinter;
import me.puneetsingh.utils.commons.trees.BinarySearchTree;
import me.puneetsingh.utils.commons.trees.TreeNode;
import me.puneetsingh.utils.sort.Shuffle;

public class CloneATree {
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
            TreeNode ctree = new TreeNode(bst.root.data);
            cloneIt(bst.root, ctree);
            BTreePrinter.printNode(ctree);
        }


    }
    public static void cloneIt(TreeNode r, TreeNode c)
    {
        if(r !=  null) {
            if(r.left!=null)
                c.left = new TreeNode(r.left.data);
            cloneIt(r.left, c.left);
            if(r.right!=null)
                c.right = new TreeNode(r.right.data);
            cloneIt(r.right, c.right);
        }
    }

}
