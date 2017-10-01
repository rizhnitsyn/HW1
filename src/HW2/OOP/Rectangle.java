package HW2.OOP;

public class Rectangle {
    private Point leftTop;
    private Point rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public double lengthOfDiagonal() {
        return leftTop.distance(rightBottom);
    }

    public double areaOfRectangle() {
        return Math.abs(rightBottom.getX() - leftTop.getX()) * Math.abs(leftTop.getY() - rightBottom.getY());
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
