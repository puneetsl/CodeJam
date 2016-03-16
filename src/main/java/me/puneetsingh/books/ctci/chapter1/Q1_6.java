package me.puneetsingh.books.ctci.chapter1;

public class Q1_6 {
    //Rotate the NxN matrix by 90 degree
    // Allowed extra memory
    private static void rotateNN90(int[][] arr) {
        int[][] tmp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, tmp[i], 0, arr[i].length);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[j][i] = tmp[i][arr[i].length - j - 1];
            }
        }
    }

    //Extra Memory is not allowed
    private static void rotateNN90NoMem(int[][] arr) {
        int N = arr.length;
        int LAYER = N / 2;
        int temp;
        for (int l = 0; l < LAYER; l++) {
            for (int i = l; i < arr.length - l - 1; i++) {
                temp = arr[l][i];
                arr[l][i] = arr[i][N - 1 - l];//ok
                arr[i][N - 1 - l] = arr[N - 1 - l][N - 1 - i];
                arr[N - 1 - l][N - 1 - i] = arr[N - 1 - i][l];
                arr[N - 1 - i][l] = temp;
            }
        }
    }

    private static int[][] generateNNMatrix(int N) {
        int[][] arr = new int[N][N];
        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = k++;
            }
        }
        return arr;
    }

    private static void printMatrix(int[][] arr) {
        for (int[] anArr : arr) {
            for (int anAnArr : anArr) {
                System.out.print(anAnArr + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = generateNNMatrix(5);
        System.out.println("Using Extra Memory");
        printMatrix(arr);
        System.out.println();
        rotateNN90(arr);
        printMatrix(arr);
        System.out.println("\nUsing No Extra Memory");
        int[][] nmarr = generateNNMatrix(5);
        printMatrix(nmarr);
        rotateNN90NoMem(nmarr);
        System.out.println();
        printMatrix(nmarr);
    }
}
