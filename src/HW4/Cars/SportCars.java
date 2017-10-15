package HW4.Cars;

public class SportCars extends Cars {
    private boolean sportMode;

    public boolean isSportMode() {
        return sportMode;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 8 * result + 6 * getSumOfChars(getManufacturer());
        result = 8 * result + 6 * getSumOfChars(getModel());
        result = 8 * result + 6 * getSumOfChars(getColor()) + 6 * Integer.parseInt(getProductionDate());
        result = 8 * result + 6 * getSumOfChars(getEngine().getDescription()) + 6 * getPower();
        result = 8 * result + 6 * (sportMode ? 17 : 34);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SportCars) {
            SportCars car = (SportCars) obj;
            return (getManufacturer().equals(car.getManufacturer())) && getModel().equals(car.getModel()) && getColor().equals(car.getColor())
                    && getProductionDate().equals(car.getProductionDate()) && getEngine().equals(car.getEngine()) && getPower() == car.getPower() && sportMode == car.isSportMode();
        }
        return false;
    }

    @Override
    public String toString() {
        return getManufacturer() + " " + getModel() + ", color: " + getColor() + ", produced in: " + getProductionDate() + ", " + getEngine().getDescription()
                + ", power: " + getPower() + ", Sport mode: " + sportMode;
    }

    public SportCars(String manufacturer, String model, String productionDate, String color, Engines engines, int power, boolean sportMode) {
        super(manufacturer, model, productionDate, color, engines, sportMode ? power + 30 : power);
        this.sportMode = true;
    }
}
