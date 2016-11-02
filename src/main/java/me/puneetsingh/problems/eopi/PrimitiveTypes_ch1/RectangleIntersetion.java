package me.puneetsingh.problems.eopi.PrimitiveTypes_ch1;

public class RectangleIntersetion {
    public static void main(String[] args) {

    }
    class Rectangle{
        // Just two points required to define a rectangle
        Point topLeft;
        Point bottomRight;
    }
    class Point{
        float x;
        float y;
        public Point(float x, float y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
