package me.puneetsingh.basics.misc;

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
    public static void main(String[] args) {
        int  points_grid[][] = {
                {119, 7, 1110, 1000},
        {2, 7, 9, 1},
        {0, 6, 2, 3},
        {1, 0, 2, 0}
        };
        System.out.println(findMaxPoints(points_grid));

    }
}
