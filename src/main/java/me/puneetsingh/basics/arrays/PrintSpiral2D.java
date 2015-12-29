package me.puneetsingh.basics.arrays;


public class PrintSpiral2D {
    static int[][] arr1= {
        {1,2,3,4},
        {12,13,14,5},
        {11,16,15,6},
        {10,9,8,7}
    };
    static int[][] arr2= {
            {1,2,3,4,5},
            {12,13,14,15,6},
            {11,10,9,8,7}
    };
    static int[][] arr3= {
            {1,2,3},
            {8,9,4},
            {7,6,5}
    };
    static int[][] arr = arr2;
    static int r = arr[0].length,  d = arr.length;
    static int l = 0,  t = 1, max= r*d, k=0;

    public static void main(String[] args) {
        move(arr, 0, 0, 0, 'r');
    }

    private static void move(int[][] arr,int i, int j, int k, char dir) {
        if(k>=max)
            return;
        if(dir=='r' && j< r)
        {
            System.out.print(arr[i][j]+" ");
            move(arr,i,j+1,k+1,'r');
        }
        else if(dir=='r')
        {
            r--;

            move(arr,i+1,j-1,k,'d');
        }

        if(dir=='d' && i< d)
        {
            System.out.print(arr[i][j]+" ");
            move(arr,i+1,j,k+1,'d');
        }
        else if(dir=='d')
        {
            d--;

            move(arr,i-1,j-1,k,'l');
        }

        if(dir=='l' && j >= l)
        {
            System.out.print(arr[i][j]+" ");
            move(arr,i,j-1,k+1,'l');
        }
        else if(dir=='l')
        {
            l++;

            move(arr,i-1,j+1,k,'t');
        }
        if(dir=='t' && i >= t)
        {
            System.out.print(arr[i][j]+" ");
            move(arr,i-1,j,k+1,'t');
        }
        else if(dir=='t')
        {

            t++;
            move(arr,i+1,j+1,k,'r');
        }

    }

}
