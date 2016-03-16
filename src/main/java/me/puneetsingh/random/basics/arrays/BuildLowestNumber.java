package me.puneetsingh.random.basics.arrays;


import java.util.LinkedList;

public class BuildLowestNumber {

    /**
     * This is a recursive implementation to find and fill the smallest number possible
     * after removing n digits from a string to a String builder. String builder would be passed by reference.
     * This implementation would use O(n) memory and O(n^2) time to run in the worst case.
     *
     *
     * @param str
     * @param n
     * @param res
     */
    void generateLowestNumber(String str, int n, StringBuilder res) {

        // If there are 0 characters to remove from str,
        // append everything to result
        if (n == 0) {
            res.append(str);
            return;
        }

        int len = str.length();

        // If there are more characters to remove than string
        // length, then append nothing to result
        if (len <= n)
            return;

        // Find the smallest character among first (n+1) characters
        // of str.
        int mi = 0;//idex with the minimum
        for (int i = 1; i <= n; i++)
            if (str.charAt(i) < str.charAt(mi))
                mi = i;

        // Append the smallest character to result
        res.append(str.charAt(mi));

        // substring starting from mi+1 to str.length() .
        String new_str = str.substring(mi + 1, len);

        // Recurse for the above substring and n equals to n-minIndex
        generateLowestNumber(new_str, n - mi, res);
    }

    // A wrapper over generateLowestNumberRec()
    String generateLowestNumber(String str, int n) {
        //Creating a string builder so that it can be filled with the final number
        StringBuilder res = new StringBuilder();

        // the result is passed by reference
        generateLowestNumber(str, n, res);

        return res.toString();
    }
    String genTemp(String str, int n)
    {
        LinkedList<Integer> ll = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c:str.toCharArray()) {
            ll.add(c-'0');
        }
//        for (Integer i :ll) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
        int mi = 0;
        boolean broke = false;
        while(ll.size() > str.length()-n)
        {

//            for (Integer i :ll) {
//                System.out.print(i+" ");
//            }
//            System.out.println();
            for (int j = 0; j < ll.size()-1; j++) {
                if(ll.get(j)>ll.get(j+1)) {
                    ll.remove(j);
                    broke = true;
                    break;
                }
            }
            if(!broke) ll.removeLast();
        }
        for (Integer i :ll) {
            sb.append(i);
        }
        return sb.toString();
    }
    public static String smallestNumberKDigits(String number, int k){

        if(number.length()==k) return number;
        if(number.length() <k) return "-1";
        char []  num = number.toCharArray();
        StringBuilder result  =  new StringBuilder();
        int start =0;
        int end = num.length-1;
        int count  = k;
        for(; start<=end && result.length() <k;){
            int length = end -start +1;
            if(length > count-1) {
                int index = findSmallestDigit(num, start, end - (count-1));
                result = result.append(num[index]);
                start = index +1;
                count--;
            }

        }

        return result.toString();
    }

    public static int findSmallestDigit(char [] nums , int start, int end){

        int smallest = nums[start];
        int index=start;
        for(int i = start; i <=end; i++){
            if(nums[i] < smallest){
                index = i;
                smallest = nums[i];
            }

        }

        return index;
    }
    public static void main(String[] args) {
        BuildLowestNumber blm = new BuildLowestNumber();
        String num = "6519273232438651927323243865192732324386519273232438651927323243865192732324386519273232438651927323243865192732324386519273232438";
        System.out.println(blm.generateLowestNumber(num, 27));
        System.out.println(blm.genTemp(num, 27));
        System.out.println(blm.smallestNumberKDigits(num, num.length()-27));
    }
}
