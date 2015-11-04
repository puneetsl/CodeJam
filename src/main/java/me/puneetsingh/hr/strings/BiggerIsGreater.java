package me.puneetsingh.hr.strings;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater
 */
public class BiggerIsGreater {
    private static String getNextGreater(String in) {
        char[] inChars = in.toCharArray();
        boolean done = false;
        if (inChars.length < 2)
            return "no answer";
        for (int i = inChars.length - 2; i >= 0; i--) {
            int nextBig = findNextBig(inChars, i);
            if (nextBig != -1) {
                char temp = inChars[i];
                inChars[i] = inChars[nextBig];
                inChars[nextBig] = temp;
                Arrays.sort(inChars, i + 1, inChars.length);
                done = true;
                break;
            }
        }
        if (!done)
            return "no answer";
        else
            return String.valueOf(inChars);
    }

    private static int findNextBig(char[] inChars, int curr) {
        char smallest = 255;
        int x = -1;
        for (int j = curr + 1; j < inChars.length; j++) {
            if (inChars[j] < smallest && inChars[j] > inChars[curr]) {
                smallest = inChars[j];
                x = j;
            }
        }
        if (smallest < inChars[curr] || smallest == 255)
            return -1;
        else
            return x;
    }

    public static void main(String[] args) {
        String[] inputs = {"a", "ab", "bb", "hefg", "dhck", "dkhc"};
        for (String in : inputs) {
            System.out.println(getNextGreater(in));
        }
    }
}
