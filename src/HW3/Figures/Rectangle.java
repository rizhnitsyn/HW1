package HW3.Figures;

import HW3.FiguresAbilities.DiagonalCalculatable;
import HW3.FiguresAbilities.HalfPerimeterCalculatable;
import HW3.Point;
import HW3.SpecialParameters;

public class Rectangle extends Figure implements DiagonalCalculatable, HalfPerimeterCalculatable {
    private Point leftTop;
    private Point rightBottom;
    private Point leftBottom;
    private Point rightTop;

    public Point getLeftBottom() {
        return leftBottom;
    }

    public Point getRightTop() {
        return rightTop;
    }

    public Rectangle(String name, Point leftTop, Point rightBottom) {
        super(name);
        super.setParamName(SpecialParameters.RECTANGLE);
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
        leftBottom = new Point(leftTop.getX(), rightBottom.getY());
        rightTop = new Point(rightBottom.getX(), leftTop.getY());
    }

    @Override
    public String toString() {
        return  getName() + " area = " + calculateArea() + ", perimeter = " + calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        return Math.abs(rightBottom.getX() - leftTop.getX()) * Math.abs(leftTop.getY() - rightBottom.getY());
    }

    @Override
    public double calculateDiagonal() {
        return leftTop.distance(rightBottom);
    }

    @Override
    public double calculatePerimeter() {
        return calculateHalfPerimeter() * 2;
    }

    @Override
    public double calculateHalfPerimeter() {
        return (leftTop.distance(rightTop) + rightTop.distance(rightBottom) + rightBottom.distance(leftBottom) + leftBottom.distance(leftTop)) / 2;
    }

    public Point getLeftTop() {
        return leftTop;
    }

    public void setLeftTop(Point leftTop) {
        this.leftTop = leftTop;
    }

    public Point getRightBottom() {
        return rightBottom;
    }

    public void setRightBottom(Point rightBottom) {
        this.rightBottom = rightBottom;
    }
}
