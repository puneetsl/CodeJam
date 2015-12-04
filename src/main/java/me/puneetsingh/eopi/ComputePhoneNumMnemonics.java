package me.puneetsingh.eopi;

import java.util.ArrayList;

/**
 * Created by pludu on 12/4/2015.
 */
public class ComputePhoneNumMnemonics {


    public static void main(String[] args) {
        ArrayList<String> dialPad = new ArrayList<String>(10);
        dialPad.add("");//0
        dialPad.add("");//1
        dialPad.add("ABC");//2
        dialPad.add("DEF");//3
        dialPad.add("GHI");//4
        dialPad.add("JKL");//5
        dialPad.add("MNO");//6
        dialPad.add("PQRS");//7
        dialPad.add("TUV");//8
        dialPad.add("WXYZ");//9
        printAllMnemonics(dialPad, 237);
    }

    private static void printAllMnemonics(ArrayList<String> dialPad, int num) {
        ArrayList<Integer> nums = new ArrayList<Integer>(10);
        long total = 1;

        while(num>0)
        {
            int x = num%10;
            num = num/10;
            nums.add(0,x);
            total = total * dialPad.get(x).length();
        }
        int[] counter = new int[nums.size()];
        int[] counterMax = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            counterMax[i] = dialPad.get(nums.get(i)).length();
        }
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < nums.size(); j++) {
                System.out.print(dialPad.get(nums.get(j)).charAt(counter[j]));
            }
            System.out.println();
            incrementCounter(counter,counterMax);
        }
    }

    private static void incrementCounter(int[] counter, int[] counterMax) {
        counter[counter.length-1]++;
        int k = 1;
        while(k < counter.length &&(counter[counter.length-k] >= counterMax[counter.length-k]))
        {
            counter[counter.length-k] = 0;
            k++;
            counter[counter.length-k]++;
        }
    }
}
