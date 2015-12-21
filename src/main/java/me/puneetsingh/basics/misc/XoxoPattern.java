package me.puneetsingh.basics.misc;


public class XoxoPattern {
    static boolean toggle=true;

    public static void main(String[] args) {
        rectXO(20,20);
    }

    private static void rectXO(int M, int N) {
        char[][] rectangle= new char[M][N];
        rectangle = recusrseXO(rectangle,0,0,'d');
        for (char[] aRectangle : rectangle) {
            for (int j = 0; j < aRectangle.length; j++) {
                System.out.print(aRectangle[j] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] recusrseXO(char[][] rectangle, int i, int j,char dir) {

        //dir= Directions
		/*
		d=down
		u=up
		r=right
		l=left
		*/
        if(i>0&&j>0&&i<rectangle.length-1&&j<rectangle[i].length-1)
        {
            if(rectangle[i+1][j]!=0&&rectangle[i-1][j]!=0&&rectangle[i][j+1]!=0&&rectangle[i][j-1]!=0)
            {
                rectangle[i][j]=assign();
                return rectangle;
            }
        }
        switch (dir) {
            case 'd':
                if(i<rectangle.length&&(rectangle[i][j]==0))
                {
                    rectangle[i][j]=assign();
                    if(i==rectangle.length-1||rectangle[i+1][j]!=0)
                    {
                        rectangle = recusrseXO(rectangle,i,j+1,'r');
                    }
                    else
                    {
                        rectangle = recusrseXO(rectangle,i+1,j,'d');
                    }
                }
                break;
            case 'r':
                if(j<rectangle[i].length&&(rectangle[i][j]==0))
                {
                    rectangle[i][j]=assign();
                    if(j==rectangle[i].length-1||rectangle[i][j+1]!=0)
                    {
                        rectangle = recusrseXO(rectangle,i-1,j,'u');
                    }
                    else
                    {
                        rectangle = recusrseXO(rectangle,i,j+1,'r');
                    }
                }
                break;
            case 'u':
                if(i>=0&&(rectangle[i][j]==0))
                {
                    rectangle[i][j]=assign();
                    if(i==0||rectangle[i-1][j]!=0)
                    {
                        rectangle = recusrseXO(rectangle,i,j-1,'l');
                    }
                    else
                    {
                        rectangle = recusrseXO(rectangle,i-1,j,'u');
                    }
                }
                break;
            case 'l':
                if(j>=0&&(rectangle[i][j]==0))
                {
                    rectangle[i][j]=assign();
                    if(j==0||rectangle[i][j-1]!=0)
                    {
                        changetoggle();
                        rectangle = recusrseXO(rectangle,i+1,j,'d');
                    }
                    else
                    {
                        rectangle = recusrseXO(rectangle,i,j-1,'l');
                    }
                }
                break;
            default:
                break;
        }
        return rectangle;
    }

    private static void changetoggle() {
        toggle = !toggle;

    }

    private static char assign() {
        if(toggle)
            return 'X';
        else
            return '-';
    }
}
