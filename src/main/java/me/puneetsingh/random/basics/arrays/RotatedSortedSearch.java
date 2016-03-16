package me.puneetsingh.random.basics.arrays;


public class RotatedSortedSearch {
    public static void main(String[] args) {
//        int a[] = {6,7,8,9,10,11,2,3,4,5};
        int a[] = {3,5,1};
        System.out.println(getIndexInRotatedSorted(a, 1));
    }

    private static int getIndexInRotatedSorted(int[] a, int i) {
        int s = 0;
        int e = a.length-1;
        return search(a,i,s,e);
    }
    public static int rBsearch(int[] L, int low, int high, int k) {


        int mid = (low + high) / 2;

        if (low > high) {
            return -1;
        } else if (L[mid] == k) {
            return mid;
        } else if (L[mid] < k) {
            return rBsearch(L, mid + 1, high, k);
        } else {
            return rBsearch(L, low, mid - 1, k);
        }
    }

    private static int search(int[] a, int i, int s, int e) {
        int m = s + (e-s)/2;

        if(a[m]==i)
            return m;

        if(a[s]<a[e])
            return rBsearch(a,s,e,i);
        if(a[m]>i) {
            if(i<=a[e]) {
                s = m + 1;
                m = s + (e - s) / 2;
                return search(a, i, s, e);
            }
            else
            {
                e = m-1;
                m = s+ (e-s)/2;
                return search(a,i,s,e);
            }
        }
        else  {
            if(i<=a[e]) {
                s = m + 1;
                m = s + (e - s) / 2;
                return search(a, i, s, e);
            }
            else
            {
                e = m-1;
                m = s+ (e-s)/2;
                return search(a,i,s,e);
            }
        }

    }
}
