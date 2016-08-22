package me.puneetsingh.problemsets.misc;

import java.nio.channels.IllegalSelectorException;

/**
 * Created by puneet on 8/21/16.
 */
public class LineIntersection {

    public static void main(String[] args) {
        Line line1 = new Line(1, 2, 3, 4);
        Line line2 = new Line(9, 6, 7, 8);
        if(doIntersect(line1,line2))
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    private static boolean doIntersect(Line line1, Line line2) {
        /*
             y = m1 * x + c1
             y = m2 * x + c2
             x = (c2 - c1) / (m1-m2)

         */
        if((line1.eq.m-line2.eq.m)==0)
        {
            //Parallel
            if ((line2.eq.c - line1.eq.c) == 0)
            {
                // same line
                return checkOverlaps(line1,line2);
            }
            else
            {
                //never meets
                return false;
            }
        }
        else
        {
            return true;
//            float x = (line2.eq.c - line1.eq.c)/(line1.eq.m-line2.eq.m);
//            float y = x*line1.eq.m+ line1.eq.c;
        }
    }

    private static boolean checkOverlaps(Line line1, Line line2) {
        // if projection on x overlaps and m is  defined
        if(!line1.eq.undefSlope)
        {
            if((line1.x1<line2.x2 && line1.x1>line2.x1)||(line2.x1<line1.x2 && line2.x1>line1.x1))
                return true;
        }
        else
        {
            if((line1.y1<line2.y2 && line1.y1>line2.y1)||(line2.y1<line1.y2 && line2.y1>line1.y1))
                return true;
        }
        return false;
    }

    static class Equation{
        float m;
        boolean undefSlope = false;
        float c;// y = m*x + c
        public Equation(Line l)
        {
            if(l.x2-l.x1 != 0)
                m = (l.y2-l.y1)/(l.x2-l.x1);
            else {
                m = Float.MAX_VALUE;
                undefSlope = true;
            }
            c = l.y2 - m * l.x2;
            if(c != (l.y1 - m * l.x1))
                throw new IllegalStateException("Something went wrong with the points");
        }
    }
    static class Line{
        float x1, y1;
        float x2, y2;
        Equation eq;
        public Line(int x1, int y1, int x2, int y2)
        {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            eq = new Equation(this);
        }
    }
}
