package me.puneetsingh.problems.others.easy.misc;

/**
 Yelp Question:
 Given a 2D grid with points in it, find the maximum points that the player can achieve.
 Player can move only up,  up-left, up-right in the grid. Player always starts
 from bottom-most row and middle column


 points_grid = [
 [9, 7, 10, 100],
 [2, 7, 9, 1],
 [0, 6, 2, 3],
 [1, 0, 2, 0]
 ]

 start_x = 3 # m - 1
 start_y = 2 # [_ n / 2 _]

 2 -> 6 -> 2 -> 9 is one possible path with number of points gained 19
 */
public class PathMax2DBottomToTop {


    static int findMaxPoints(int[][] grid)
    {
        int max=0;
        return findMaxPoints(grid, grid[0].length-1, grid.length/2, 0, max);

    }

    static int findMaxPoints(int[][] grid, int x, int y, int sum,int max)
    {
        sum = sum + grid[x][y];
        if(x==0)
        {
            if(max < sum)
                max = sum;
            return max;
        }
        if(y>0)
            max = findMaxPoints(grid, x-1, y-1, sum, max);
        if(y<grid.length-1)
            max = findMaxPoints(grid, x-1, y+1, sum, max);
        max = findMaxPoints(grid, x-1, y, sum, max);
        return  max;

    }
    static int findMaxPointsDP(int[][] grid)
    {
        return findMaxPointsDP(grid, grid[0].length-1, grid.length/2);
    }

    private static int findMaxPointsDP(int[][] grid, int x, int y) {
        int [][] DP = new int[grid.length][grid[0].length];
        DP[x][y] = grid[x][y];
        int sr = y;
        int er = y;
        int m;
        for(int i=x-1;i>=0;i--)
        {
            if(sr>0)
                sr--;
            if(er<grid[0].length-1)
                er++;
            for(m = sr;m<=er;m++)
            {
                int a = m-1>=sr?DP[i+1][m-1]:0;
                int b = m+1<=er?DP[i+1][m+1]:0;
                int c = m>sr&&m<er?DP[i+1][m]:0;
                int temp  = grid[i][m]+Math.max(a,Math.max(b,c));
                DP[i][m] = DP[i][m]>temp?DP[i][m]:temp;
            }
        }
        int max = 0;
        for(int i=0;i<DP[0].length;i++)
        {
            if(DP[0][i]>max)
                max = DP[0][i];
        }
        return max;
    }

    public static void main(String[] args) {
        int  points_grid[][] =
                {{2,3,4,4,4,4,3,2},
                { 3,4,6,6,6,6,4,3 },
                { 4,6,8,8,8,8,6,4 },
                { 4,6,8,8,8,8,6,4 },
                { 4,6,8,8,8,8,6,4 },
                { 4,6,8,8,8,8,6,4 },
                { 3,4,6,6,6,6,4,3 },
                { 2,3,4,4,4,4,3,2}};
        long startTime = System.nanoTime();
        System.out.println(findMaxPoints(points_grid));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) +" MS");
        startTime = System.nanoTime();
        System.out.println(findMaxPointsDP(points_grid));
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) +" MS");

    }
}
