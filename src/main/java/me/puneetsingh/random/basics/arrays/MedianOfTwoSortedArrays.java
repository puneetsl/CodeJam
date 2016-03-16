package me.puneetsingh.random.basics.arrays;

public class MedianOfTwoSortedArrays {
    public static float findMedian(int[] a, int[] b) {
        int N = a.length + b.length;
        int i = (N / 2);
        boolean isEven = N % 2 == 0;
        if (isEven)
            return (float) (findIndexValue(a, b, i - 1) + findIndexValue(a, b, i)) / 2.0f;
        else
            return (float) findIndexValue(a, b, i);
    }

    private static int findIndexValue(int[] a, int[] b, int i) {


        return ksmallest(a,b,0,a.length,0,b.length,i);
    }
    public static int ksmallest(int[] a, int[] b,
                                int a1, int a2, int b1, int b2,
                                int k) {
        int lena = a2 - a1;
        int lenb = b2 - b1;
        assert (0 <= k && k < (lena + lenb));
        if (lena == 0) {
            return b[b1 + k];
        }
        if (lenb == 0) {
            return a[a1 + k];
        }
        int mida = lena / 2;
        int midb = lenb / 2;
        int ma = a[a1 + mida];
        int mb = b[b1 + midb];
        if ((mida + midb) < k) {
            return (mb < ma) ?
                    ksmallest(a, b, a1, a2, b1 + midb + 1, b2, k - (midb + 1)) :
                    ksmallest(a, b, a1 + mida + 1, a2, b1, b2, k - (mida + 1));
        }
        else {
            return (mb < ma) ?
                    ksmallest(a, b, a1, a1 + mida, b1, b2, k) :
                    ksmallest(a, b, a1, a2, b1, b1 + midb, k);
        }
    }
    private static float complicatedMedian(int a[],int b[])
    {
        int N = a.length + b.length;
        int i = (N / 2);
        boolean isEven = N % 2 == 0;
        if (isEven)
            return (float) (complicatedMedian(a, b, i - 1) + complicatedMedian(a, b, i)) / 2.0f;
        else
            return (float) complicatedMedian(a, b, i);
    }
    private static int complicatedMedian(int a[],int b[], int k)
    {
        int s = 0, e = a.length;
        int mid = 0;
        int indexM1 = 0;
        while(indexM1!=k&&e>=s)
        {
            mid = s+ (e-s)/2;

            indexM1 = mergePosition(a,b,mid);
            if(k<indexM1)
            {
                e = mid -1;
            }
            else
            {
                s = mid + 1;
            }
        }
        if(k==indexM1)
            return a[mid];
        s = 0; e = b.length;
        mid = 0;
        indexM1 = 0;
        while(indexM1!=k&&e>=s)
        {
            mid = s+ (e-s)/2;

            indexM1 = mergePosition(b,a,mid);
            if(k<indexM1)
            {
                e = mid -1;
            }
            else
            {
                s = mid + 1;
            }
        }
        if(k==indexM1)
            return b[mid];
        return -1;
    }
    private static int mergePosition(int[] a, int[] b, int i)
    {
       // System.out.println("Searching "+a[i]+" in b, got: "+serachIndex(b,a[i])+" index");
        return serachIndex(b,a[i])+i;
    }
    private static int serachIndex(int[] a, int s) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        if (s > a[high])
            return high + 1;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (a[mid] > s)
                high = mid - 1;
            else if (a[mid] < s)
                low = mid + 1;
            else
                return mid; // found
        }

        return a[mid]<s?mid+1:mid; // not found
    }


    public static void main(String[] args) {
        int[] a = {1, 3, 9, 10, 11};
        int[] b = {2, 5,  13, 17, 45};
        //1,2,3,5,7,9,10,11,12,13,17,19
        System.out.println(complicatedMedian(a,b));
        System.out.println(findMedian(a, b));
    }
}
