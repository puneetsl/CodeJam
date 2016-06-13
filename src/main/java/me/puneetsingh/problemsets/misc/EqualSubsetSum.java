package me.puneetsingh.problemsets.misc;


import me.puneetsingh.utils.sort.QuickSort;

import java.util.*;

public class EqualSubsetSum {
    // Returns true if arr[] can be partitioned in two subsets of
    // equal sum, otherwise false
    static boolean findPartition (Integer arr[], int n)
    {
        int sum = 0;
        int i, j;

        // Caculcate sun of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];

        if (sum%2 != 0)
            return false;

        boolean part[][]=new boolean[sum/2+1][n+1];

        // initialize top row as true
        for (i = 0; i <= n; i++)
            part[0][i] = true;

        // initialize leftmost column, except part[0][0], as 0
        for (i = 1; i <= sum/2; i++)
            part[i][0] = false;

        // Fill the partition table in botton up manner
        for (i = 1; i <= sum/2; i++)
        {
            for (j = 1; j <= n; j++)
            {
                part[i][j] = part[i][j-1];
                if (i >= arr[j-1])
                    part[i][j] = part[i][j] ||
                            part[i - arr[j-1]][j-1];
            }
        }
        return part[sum/2][n];
    }
    static boolean greedyPartition (Integer arr[])
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        if(sum%2==1)
            return false;
        QuickSort.sort(arr);
        sum /=2;
        HashSet a = new HashSet();
        HashSet b = new HashSet();
        int s1=0, s2=0;
        int n = arr.length-1;
        for (int i = n; i >=0 ; i--) {
            if(a.isEmpty()) {
                a.add(arr[i]);
                s1=arr[i];
            }
            else if(b.isEmpty()) {
                b.add(arr[i]);
                s2 = arr[i];
            }
            else
            {
                if(s1>=s2)
                {
                    b.add(arr[i]);
                    s2+=arr[i];
                }
                else
                {
                    a.add(arr[i]);
                    s1+=arr[i];
                }
            }
        }

        if(s1==sum) {
//            System.out.println("Sum1 "+s1+", "+Arrays.toString(a.toArray()));
//            System.out.println("Sum2 "+s2+", "+Arrays.toString(b.toArray()));
            return true;
        }
        else
        {
//            int diff = Math.abs(s1-s2)/2;
//            Iterator<Integer> it = a.iterator();
//            while(it.hasNext())
//            {
//                Integer tmp = it.next();
//                if(b.contains(tmp-diff)||b.contains(tmp+diff)) {
//                    int x = b.contains(tmp-diff)?tmp-diff:tmp+diff;
//                    a.add(x);
//                    a.remove(tmp);
//                    s1+=x;
//                    s1-=tmp;
//                    b.add(tmp);
//                    s2+=tmp;
//                    s2-=x;
//                    b.remove(x);
//                    System.out.println(":Sum1 "+s1+", "+Arrays.toString(a.toArray()));
//                    System.out.println(":Sum2 "+s2+", "+Arrays.toString(b.toArray()));
//                    return true;
//                }
//                else
            return findPartition(arr,arr.length);
//        }


        }
//        return false;
    }

    public static void main(String[] args) {
        Integer[] arr = generateRandomIntArr(10,1000);
        long t1=0,t2=0,c1=0,c2=0;
        long startTime = System.nanoTime();
        boolean b1 = greedyPartition(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 10000;
        t1+=duration;
        c1++;
        startTime = System.nanoTime();
        boolean b2 = findPartition(arr,10);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 10000;
        t2+=duration;
        c2++;
        for (int i = 0; i < 10000; i++)
        {
//            System.out.println(b1+":"+b2+", Worked for: "+ Arrays.toString(arr));
            arr = generateRandomIntArr(10,1000);
            startTime = System.nanoTime();
            b1 = greedyPartition(arr);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 10000;
            t1+=duration;
            c1++;

            startTime = System.nanoTime();
            b2 = findPartition(arr,10);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 10000;
            t2+=duration;
            c2++;
        }
        System.out.println("Greedy Avg"+(t1));
        System.out.println("DP Avg"+(t2));
//        System.out.println("\n\n"+b1+":"+b2+", Failed for: "+Arrays.toString(arr));
    }

    private static Integer[] generateRandomIntArr(int i, int limit) {
        Integer[] arr = new Integer[i];
        Random r = new Random();
        for (int j = 0; j < i; j++) {
            arr[j] = r.nextInt(limit);
        }
        return arr;
    }
}
