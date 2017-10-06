package HW3.Figures;

import HW3.FiguresAbilities.AreaCalculatable;
import HW3.FiguresAbilities.PerimeterCalculatable;
import HW3.SpecialParameters;

public abstract class Figure implements AreaCalculatable, PerimeterCalculatable {
    private String name;
    private SpecialParameters paramName;

    public Figure(String name) {
        this.name = name;
    }

    public boolean areAreasEqual(Figure figure) {
        return calculateArea() == figure.calculateArea();
    }

    @Override
    public abstract String toString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpecialParameters getParamName() {
        return paramName;
    }

    public void setParamName(SpecialParameters paramName) {
        this.paramName = paramName;
    }
}
