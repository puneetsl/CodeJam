package me.puneetsingh.problems.others.easy.arrays;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchFlag {
    public static enum Color { RED, WHITE, BLUE }

    public static void dutchFlagPartition(int pivotIndex, List<Color> A) {

        //RED
        int k = itrColor(A, Color.RED, 0);
        //White and Blue
        System.out.println("##"+A.get(k-1));
        k = itrColor(A, Color.WHITE, k);
    }
    public static int itrColor(List<Color> A, Color c, int k)
    {
        int i=k;
        int j=A.size()-1;

        while(i<=j)
        {
            while(i<A.size()&&A.get(i)==c)
                i++;
            while(j>=0&&A.get(j)!=c)
                j--;
            if (i <= j) {
                Collections.swap(A, i, j);
                i++;j--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Color[] arr = {Color.WHITE,Color.RED,Color.WHITE,Color.RED,Color.WHITE,Color.RED,
        Color.BLUE,Color.BLUE,Color.WHITE,Color.BLUE
        };
        List<Color> A = Arrays.asList(arr);

        dutchFlagPartition(0,A);
        System.out.println(A);

    }
}
