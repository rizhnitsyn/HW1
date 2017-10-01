package HW2.OOP;

public class TestPointAndRectangle {
    public static void main(String[] args) {
        Point leftTopPoint = new Point(-1, 1);
        Point rightBottomPoint = new Point(1, -1);
        System.out.println("Length between two points: " + leftTopPoint.distance(rightBottomPoint));
        Rectangle rectangle = new Rectangle(leftTopPoint, rightBottomPoint);
        System.out.println("Length of diagonal of rectangle: " + rectangle.lengthOfDiagonal());
        System.out.println("Area of rectangle: " + rectangle.areaOfRectangle());
    }
}
