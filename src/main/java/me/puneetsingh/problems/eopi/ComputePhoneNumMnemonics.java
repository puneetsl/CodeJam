package me.puneetsingh.problems.eopi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

        ArrayList<String> permyOut = new ArrayList<>();
        long startTime = System.nanoTime();
        printAllMnemonics(dialPad, 237898);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 10000;
        System.out.println("Iterative : "+ duration + " MS");

        startTime = System.nanoTime();
        printPermu(dialPad, "","237898", permyOut);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 10000;
        System.out.println("Recursive: "+ duration + " MS");



    }

    private static List<String> printAllMnemonics(ArrayList<String> dialPad, int num) {
        ArrayList<Integer> nums = new ArrayList<Integer>(10);
        ArrayList<String> out = new ArrayList<>();
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {

            for (int j = 0; j < nums.size(); j++) {
                sb.append(dialPad.get(nums.get(j)).charAt(counter[j]));
            }
            out.add(sb.toString());
            sb.delete(0, sb.length());
            incrementCounter(counter,counterMax);
        }
        return out;
    }
    public static void printPermu(ArrayList<String> T9, String curr, String number, ArrayList<String> permyOut)
    {
        int now=0;
        if(number.length()==0)
        {
            permyOut.add(curr);
        }
        for(int i=0;i<number.length();i++)
        {

            now = number.charAt(i)-48;
            if(now<1||now>9)
                continue;
            String gotT9 = T9.get(now);
            for(int j=0;j<gotT9.length();j++)
            {
                printPermu(T9, curr+gotT9.charAt(j),number.substring(0,i)+number.substring(i+1,number.length()), permyOut);
            }
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
