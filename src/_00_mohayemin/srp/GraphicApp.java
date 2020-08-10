// A class should have only one reason to change

package _00_mohayemin.srp;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

class GeomCircle {
    private double radius;
    private Point center;

    public GeomCircle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double diameter() {
        return radius * 2;
    }

    public Line2D tangent(Point point){
        // use radius center
        // diameter()
        return null;
    }

    public boolean contains(Point aPoint) {
        return center.distance(aPoint) <= radius;
    }


    public void fill(Color fillColor) {
        // fill it with the specified color
        // may use contains() method
    }

    public void drawOutline(){

    }
}

class PaintableCircle {
    private GeomCircle circle;
    private Color fillColor;
    private Color lineColor;

    public PaintableCircle(GeomCircle circle, Color fillColor, Color lineColor) {
        this.circle = circle;
        this.fillColor = fillColor;
        this.lineColor = lineColor;
    }

    public void fill() {
        // fill it with the specified color
        // may use contains() method
    }

    public void drawOutline() {
        // use line color to draw outline
    }
}

class GeomCircleUser {
    void use(double radius, Point center) {
        GeomCircle circle = new GeomCircle(radius, center);
        if(circle.contains(new Point(3, 6)))
            System.out.println("it is inside");

        Line2D tangent = circle.tangent(new Point(3, 6));

        
    }
}










