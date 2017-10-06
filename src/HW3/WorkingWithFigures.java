package HW3;

import HW3.Figures.*;

public class WorkingWithFigures {
    public static void main(String[] args) {
        Point leftTopPoint =  new Point(-2, 2);
        Point rightBottom = new Point(1, 0);
        Point trianglePoint = new Point(1,2);
        Figure[] figures = createFigures(leftTopPoint,rightBottom ,trianglePoint , 2,2);

        printParametersOfFigures(figures);
        printSpecialParametersOfFigures(figures);
        compareAreas(figures);

        System.out.println(ShapeUtils.isRectangle(figures[0]) ? figures[0].getName() + " is Rectangle" : figures[0].getName() + " is not Rectangle");
        System.out.println(ShapeUtils.isTriangle(figures[2]) ? figures[2].getName() + " is Rectangle" : figures[2].getName() + " is not Rectangle");
    }

    public static void printParametersOfFigures(Figure[] figures) {
        for (Figure figure: figures) {
            System.out.println(figure.toString());
        }
        System.out.println();
    }

    public static void printSpecialParametersOfFigures(Figure[] figures) {
        if (figures[0] instanceof Rectangle) {
            System.out.println(figures[0].getName() + " special parameter: " + figures[0].getParamName().getDescription() + " " + ((Rectangle) figures[0]).calculateDiagonal());
        }
        if (figures[1] instanceof Triangle) {
            System.out.println(figures[1].getName() + " special parameter: " + figures[1].getParamName().getDescription() + " " + ((Triangle) figures[1]).calculateOneOfTheTriangleHeight());
        }
        if (figures[2] instanceof Circle) {
            System.out.println(figures[2].getName() + " special parameter: " + figures[2].getParamName().getDescription() + " " + ((Circle) figures[2]).calculateDiameter());
        }
        System.out.println();
    }

    public static Figure[] createFigures(Point point1, Point point2, Point point3, int radius1, int radius2) {
        Figure[] figures = new Figure[5];
        figures[0] = new Rectangle("Rectangle", point1, point2);
        figures[1] = new Triangle("Triangle", point1, point2, point3);
        figures[2] = new Circle("Circle", radius1);
        figures[3] = new Ellipse("Elips", radius1, radius2);
        figures[4] = new Trapeze("Trapeze", point1, point2, radius1);

        return figures;
    }

    public static void compareAreas(Figure[] figures) {
        System.out.println(figures[0].areAreasEqual(figures[1]) ? "Areas of " + figures[0].getName() + " and " + figures[1].getName() + " are equal" :
                                                                  "Areas of " + figures[0].getName() + " and " + figures[1].getName() + " are not equal");

        System.out.println(figures[2].areAreasEqual(figures[3]) ? "Areas of " + figures[2].getName() + " and " + figures[3].getName() + " are equal" :
                                                                  "Areas of " + figures[2].getName() + " and " + figures[3].getName() + " are not equal");
        System.out.println();
    }
}
