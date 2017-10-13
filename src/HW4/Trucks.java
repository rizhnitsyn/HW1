package HW4;

public class Trucks extends Cars {
    private int loadingCapacipyInTons;

    public int getLoadingCapacipyInTons() {
        return loadingCapacipyInTons;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 13 * result + 6 * getSumOfChars(getManufacturer());
        result = 13 * result + 6 * getSumOfChars(getModel());
        result = 13 * result + 6 * getSumOfChars(getColor()) + 6 * Integer.parseInt(getProductionDate());
        result = 13 * result + 6 * getSumOfChars(getEngine().getDescription()) + 6 * getPower();
        result = 13 * result + 6 * loadingCapacipyInTons;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Trucks) {
            Trucks car = (Trucks) obj;
            return (getManufacturer().equals(car.getManufacturer())) && getModel().equals(car.getModel()) && getColor().equals(car.getColor())
                    && getProductionDate().equals(car.getProductionDate()) && getEngine().equals(car.getEngine()) && getPower() == car.getPower() && loadingCapacipyInTons == car.loadingCapacipyInTons;
        }
        return false;
    }

    @Override
    public String toString() {
        return getManufacturer() + " " + getModel() + ", color: " + getColor() + ", produced in: " + getProductionDate() + ", " + getEngine().getDescription()
                + ", power: " + getPower() + ", Loading capacipy in tons: " + loadingCapacipyInTons;
    }

    public Trucks(String manufacturer, String model, String productionDate, String color, Engines engine, int loadingCapacipyInTons) {
        super(manufacturer, model, productionDate, color, engine, 125);
        this.loadingCapacipyInTons = loadingCapacipyInTons;
    }
}
