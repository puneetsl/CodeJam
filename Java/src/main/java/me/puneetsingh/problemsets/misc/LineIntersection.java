package me.puneetsingh.problemsets.misc;

import java.nio.channels.IllegalSelectorException;

/**
 * Created by puneet on 8/21/16.
 */
public class LineIntersection {
    public static void main(String[] args) {
        /*
        GFG tests
        struct Point p1 = {1, 1}, q1 = {10, 1};
    struct Point p2 = {1, 2}, q2 = {10, 2};

    doIntersect(p1, q1, p2, q2)? cout << "Yes\n": cout << "No\n";

    p1 = {10, 0}, q1 = {0, 10};
    p2 = {0, 0}, q2 = {10, 10};
    doIntersect(p1, q1, p2, q2)? cout << "Yes\n": cout << "No\n";

    p1 = {-5, -5}, q1 = {0, 0};
    p2 = {1, 1}, q2 = {10, 10};
         */
        Line line1 = new Line(1, 1, 10, 1);
        Line line2 = new Line(1, 2, 10, 2);
        printYN(line1,line2);
        line1 = new Line(10, 0, 0, 10);
        line2 = new Line(0, 0, 10, 10);
        printYN(line1,line2);
        line1 = new Line(-5, -5, 0, 0);
        line2 = new Line(1, 1, 10, 10);
        printYN(line1,line2);
    }

    private static void printYN(Line line1, Line line2) {

        if (doIntersect(line1, line2))
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
        if ((line1.eq.m - line2.eq.m) == 0) {
            //Parallel
            if ((line2.eq.c - line1.eq.c) == 0) {
                // same line
                return checkOverlaps(line1, line2);
            } else {
                //never meets
                return false;
            }
        } else {
            float x = (line2.eq.c - line1.eq.c) / (line1.eq.m - line2.eq.m);
            float y = x * line1.eq.m + line1.eq.c;
            return checkPointinLines(line1, line2, x, y);
        }
    }

    private static boolean checkPointinLines(Line line1, Line line2, float x, float y) {
        boolean a = distance(line1.x1, x, line1.y1, y) + distance(x, line1.x2, y, line1.y2) == distance(line1.x1, line1.x2, line1.y1, line1.y2);
        boolean b = distance(line2.x1, x, line2.y1, y) + distance(x, line2.x2, y, line2.y2) == distance(line2.x1, line2.x2, line2.y1, line2.y2);
        return a&&b;
    }

    public static double distance(float x1, float x2, float y1, float y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private static boolean checkOverlaps(Line line1, Line line2) {
        // if projection on x overlaps and m is  defined
        if (!line1.eq.undefSlope) {
            if ((line1.x1 < line2.x2 && line1.x1 > line2.x1) || (line2.x1 < line1.x2 && line2.x1 > line1.x1))
                return true;
        } else {
            if ((line1.y1 < line2.y2 && line1.y1 > line2.y1) || (line2.y1 < line1.y2 && line2.y1 > line1.y1))
                return true;
        }
        return false;
    }

    static class Equation {
        float m;
        boolean undefSlope = false;
        float c;// y = m*x + c

        public Equation(Line l) {
            if (l.x2 - l.x1 != 0)
                m = (l.y2 - l.y1) / (l.x2 - l.x1);
            else {
                m = Float.MAX_VALUE;
                undefSlope = true;
            }
            c = l.y2 - m * l.x2;
            if (c != (l.y1 - m * l.x1))
                throw new IllegalStateException("Something went wrong with the points");
        }
    }

    static class Line {
        float x1, y1;
        float x2, y2;
        Equation eq;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            eq = new Equation(this);
        }
    }
}
