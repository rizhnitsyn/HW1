package HW3.Figures;

import HW3.FiguresAbilities.DiameterCalculatable;
import HW3.SpecialParameters;

public class Circle extends Ellipse implements DiameterCalculatable {

    public Circle(String name, int radius) {
        super(name, radius, radius);
        super.setParamName(SpecialParameters.CIRCLE);
    }

    @Override
    public double calculateDiameter() {
        return getRadius1() + getRadius2();
    }
}
