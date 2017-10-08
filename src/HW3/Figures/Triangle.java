package HW3.Figures;

import HW3.FiguresAbilities.HalfPerimeterCalculatable;
import HW3.FiguresAbilities.TriangleHeightCalculatable;

public class Triangle extends Figure implements TriangleHeightCalculatable, HalfPerimeterCalculatable {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private double firstLine;
    private double secondLine;
    private double thirdLine;

    public Triangle(String name, Point firstPoint, Point secondPoint, Point thirdPoint) {
        super(name);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        super.setParamName(SpecialParameters.TRIANGLE);
        firstLine = firstPoint.distance(secondPoint);
        secondLine = secondPoint.distance(thirdPoint);
        thirdLine = thirdPoint.distance(firstPoint);
    }

    @Override
    public String toString() {
        return getName() + " area = " + calculateArea() + ", perimeter = " + calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        return (firstLine * calculateOneOfTheTriangleHeight()) / 2;
    }

    @Override
    public double calculateOneOfTheTriangleHeight() {
        double halfPerimeter = calculateHalfPerimeter();
        return 2 * Math.sqrt(halfPerimeter * (halfPerimeter - firstLine) * (halfPerimeter - secondLine) * (halfPerimeter - thirdLine)) / firstLine;
    }

    @Override
    public double calculatePerimeter() {
        return firstLine + secondLine + thirdLine;
    }

    @Override
    public double calculateHalfPerimeter() {
        return (firstLine + secondLine + thirdLine) / 2;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }
}
