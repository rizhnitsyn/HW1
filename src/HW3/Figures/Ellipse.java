package HW3.Figures;

public class Ellipse extends Figure {
    private int radius1;
    private int radius2;

    public Ellipse(String name, int radius1, int radius2) {
        super(name);
        this.radius2 = radius2;
        this.radius1 = radius2;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius1 * radius2;
    }

    @Override
    public String toString() {
        return getName() + " area = " + calculateArea() + ", perimeter = " + calculatePerimeter();
    }

    @Override
    public double calculatePerimeter() {
        return 4 * (Math.PI * radius1 * radius2 +  Math.pow(radius1 - radius2, 2)) / (radius2 +radius1);
    }
    public int getRadius2() {
        return radius2;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

    public int getRadius1() {
        return radius1;
    }

    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }
}
