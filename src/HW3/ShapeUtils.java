package HW3;

import HW3.Figures.Figure;
import HW3.Figures.Rectangle;
import HW3.Figures.Triangle;

public class ShapeUtils {
    public static boolean isRectangle(Figure figure) {
        return figure instanceof Rectangle;
    }

    public static boolean isTriangle(Figure figure) {
        return figure instanceof Triangle;
    }
}
