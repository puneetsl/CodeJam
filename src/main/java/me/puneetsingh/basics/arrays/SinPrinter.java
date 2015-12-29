package me.puneetsingh.basics.arrays;


public class SinPrinter {
    public static void main(String[] args) {
        String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent mollis, purus id scelerisque " +
                "sollicitudin, nisl urna laoreet mauris, eget vestibulum nibh ligula at augue. Donec et finibus"+
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent mollis, purus id scelerisque " +
                "sollicitudin, nisl urna laoreet mauris, eget vestibulum nibh ligula at augue. Donec et finibus" +
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent mollis, purus id scelerisque " +
                "sollicitudin, nisl urna laoreet mauris, eget vestibulum nibh ligula at augue. Donec et finibus";

        int verticalHt = 30;

        printSin(s,verticalHt);
    }

    private static void printSin(String s, int verticalHt) {
        char[][] grid = new char[verticalHt][s.length()];
        double v = (Math.PI*6)/(s.length());
        double x=0;

        for (int i=0; i<s.length(); i++)
        {
            int h = (int) (verticalHt*Math.sin(x)/2)+verticalHt/2;
            if(h == verticalHt)
                h--;
            x+=v;
            System.out.println(h);
            grid[h][i] = s.charAt(i);
        }
        for (int i=0; i< verticalHt; i++)
        {
            for (int j = 0; j < s.length(); j++) {
                if(grid[i][j]!=0)
                    System.out.print(grid[i][j]);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
