package me.puneetsingh.problems.leetcode;


import java.util.*;


public class KSmallestPairs_373 {
    public static void main(String[] args) {
//        int[] a = {-476570184, -423568801, -385585840, -375390924, -364630569, -359795128, -281872968, -126410430, -75677925, -54214495, -49178055, -32637211, -32198215, 3413177, 19045759, 62248526, 67551536, 113606647, 155411580, 164755463, 164781059, 203133270, 277305105, 284913246, 285973110, 296436629, 325431544, 357294459, 378678394, 399786157};
//        int[] b = {-408663357, -404578641, -376531700, -311642519, -294905976, -232001207, -183530032, -141524508, -115652480, -70696522, -63386299, -54656543, -32316999, 29714175, 33993996, 45020708, 62165363, 84210823, 93905151, 102177224, 209285622, 288668099, 328300713, 338684779, 342861859, 384940859, 408019604, 410097843, 458721542, 475395296};
        int[] a = {1, 7, 11};
        int[] b = {2, 4, 6};
        int k = 9;

        KSmallestPairs_373 nks = new KSmallestPairs_373();

        List<int[]> ll = nks.kSmallestPairsDP(a, b, k);
        for (int[] i : ll) {
            System.out.println(i[0] + " " + i[1]);
        }
        System.out.println("--------------------------");
        ll = nks.kSmallestPairsHeap(a, b, k);
        for (int[] i : ll) {
            System.out.println(i[0] + " " + i[1]);
        }

    }

    public List<int[]> kSmallestPairsDP(int[] nums1, int[] nums2, int k) {
        // O(k)
        if (nums1.length == 0 || nums2.length == 0) return new ArrayList<int[]>();
        if (k > (nums1.length * nums2.length)) k = nums1.length * nums2.length;
        // DP
        List<int[]> result = new ArrayList<>(k);
        int[] dpIndex = new int[nums1.length]; // init with all 0
        int index = 0;
        int minIndex = 0, min = 0, i = 0;
        while(k-- > 0)
        {
            if(dpIndex[index]>=nums2.length) index++;//if num2 has been fully travered for dpIndex[index] move on to next
            minIndex = index; // let' start start with index
            /*
                for each value to nums1 get index of nums2 with last best index+1
                and consider it as minimum for the time being
            */
            min = nums1[index] + nums2[dpIndex[index]];
            i = index;
            /*
                if there is a possibility to check the next index and dpIndex is anything but 0
                it means there is a possibility of having even a better min value
                thus we increament i for all the next values in dpIndex where dpIndex[i] is not 0
                and its sum produces lesser than current min value

                if such a case occurs, replace minIndex with this index
            */
            while (i < dpIndex.length - 1 && dpIndex[i] != 0){
                i++;
                if (min > nums1[i] + nums2[dpIndex[i]]) {
                    min = nums1[i] + nums2[dpIndex[i]];
                    minIndex = i;
                }
            }
            result.add(new int[]{nums1[minIndex], nums2[dpIndex[minIndex]]});
            dpIndex[minIndex]++;//never use the same (minindex, dpIndex[minIndex]) pairs again :)
        }
        return result;
    }
    public List<int[]> kSmallestPairsHeap(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) return new ArrayList<int[]>();
        if (k > (nums1.length * nums2.length)) k = nums1.length * nums2.length;
        int i = 0;
        int j = 0;
        int f = nums1[i] + nums2[j];
        HashSet<String> visited = new HashSet<>(k);
        PriorityQueue<Pair> h = new PriorityQueue<>(k, new MyComparator());
        h.offer(new Pair(i, j, f));
        List<int[]> ret = new ArrayList<>(k);
        for (int s = 0; s < k; s++) {
            Pair pop = h.remove();
            i = pop.i;
            j = pop.j;
            if (i < nums1.length && j < nums2.length) {
                int[] x = {nums1[i], nums2[j]};
                ret.add(x);
            }
            if (!visited.contains(cantor(i, j + 1)) && i < nums1.length && j < nums2.length) {
                h.offer(new Pair(i, (j + 1), j >= nums2.length - 1 ? Integer.MAX_VALUE : nums1[i] + nums2[j + 1]));
                visited.add(cantor(i, j + 1));
            }
            if (!visited.contains(cantor(i + 1, j)) && i < nums1.length && j < nums2.length) {
                h.offer(new Pair((i + 1), j, i >= nums1.length - 1 ? Integer.MAX_VALUE : nums1[i + 1] + nums2[j]));
                visited.add(cantor(i + 1, j));
            }
        }
        return ret;
    }

    String cantor(int a, int b) {
        return String.valueOf(a) + "," + String.valueOf(b);
    }

    final class Pair {
        int i;
        int j;
        int sum;

        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    class MyComparator implements Comparator<Pair> {

        public int compare(Pair a, Pair b) {
            return a.sum - b.sum;
        }
    }
}
