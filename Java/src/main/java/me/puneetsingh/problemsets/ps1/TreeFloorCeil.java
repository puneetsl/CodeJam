package me.puneetsingh.problemsets.ps1;


import me.puneetsingh.utils.sort.Shuffle;
import me.puneetsingh.utils.commons.trees.BinarySearchTree;
import me.puneetsingh.utils.commons.trees.TreeNode;
import me.puneetsingh.utils.commons.trees.BTreePrinter;

public class TreeFloorCeil {

    public static int search(TreeNode root, float n)
    {

        if(root!=null&&root.data==n) {
            System.out.println("equal");
            return root.data;
        }

        if(root.data>n)
            if(root.left!=null)
                return search(root.left, n);
        else
            if(root.right!=null)
                return search(root.right, n);
        return root.data;
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
        System.out.println(search(bst.root,2.0f));
        BTreePrinter.printNode(bst.root);
    }
}
