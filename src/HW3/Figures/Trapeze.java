package HW3.Figures;

import HW3.Point;

public class Trapeze extends Rectangle {

    Triangle triangle;

    public Trapeze(String name, Point leftTop, Point rightBottom, int offSet) {
        super(name, leftTop, rightBottom);
        triangle = new Triangle("TriangleInTrapeze", rightBottom, getRightTop(), new Point((rightBottom.getX() + offSet), rightBottom.getY()));
    }

    @Override
    public String toString() {
        return  getName() + " area = " + calculateArea() + ", perimeter = " + calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        return super.calculateArea() + triangle.calculateArea() * 2;
    }

    @Override
    public double calculatePerimeter() {
        return (super.calculatePerimeter() + triangle.calculatePerimeter() * 2) - getRightBottom().distance(getRightTop()) * 2;
    }
}
