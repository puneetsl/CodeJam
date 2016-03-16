package me.puneetsingh.random.basics.arrays;


public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,47,47,55,47,
                15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,36,47,60,47,
                18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27};

        MajorityElement me = new MajorityElement();
        int len = arr.length;
        System.out.println(select(arr,0,len,len/2));
    }



    static int select(int[] list, int lo, int hi, int k) {
        int n = hi - lo;
        if (n < 2)
            return lo;

        int pivot = list[lo + (k * 7919) % n]; // Pick a random pivot

        // Triage list to [<pivot][=pivot][>pivot]
        int nLess = 0, nSame = 0, nMore = 0;
        int lo3 = lo;
        int hi3 = hi;
        int cnt =0;
        while (lo3 < hi3) {
            int e = list[lo3];
            int cmp = e - pivot;
            if (cmp < 0) {
                nLess++;
                if(list[lo3]==pivot) cnt++;
                lo3++;
            } else if (cmp > 0) {
                if(list[hi-3]==pivot) cnt++;
                swap(list, lo3, --hi3);
                if (nSame > 0)
                    swap(list, hi3, hi3 + nSame);
                nMore++;
            } else {
                nSame++;
                swap(list, lo3, --hi3);
            }
        }



        if(cnt > list.length/2)
            return pivot;
        System.out.println("p:"+pivot+" : "+cnt);
        if (k >= n - nMore)
            return select(list, hi - nMore, hi, k - nLess - nSame);
        else if (k < nLess)
            return select(list, lo, lo + nLess, k);
        return list[lo + k];
    }
    public static void swap(int[] comparables, int i, int j) {
        int swp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = swp;
    }
}
