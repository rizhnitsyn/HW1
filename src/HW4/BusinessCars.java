package HW4;

public class BusinessCars extends Cars {
    private boolean personalDriver;

    public boolean isPersonalDriver() {
        return personalDriver;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 9 * result + 6 * getSumOfChars(getManufacturer());
        result = 9 * result + 6 * getSumOfChars(getModel());
        result = 9 * result + 6 * getSumOfChars(getColor()) + 6 * Integer.parseInt(getProductionDate());
        result = 9 * result + 6 * getSumOfChars(getEngine().getDescription()) + 6 * getPower();
        result = 9 * result + 6 * (personalDriver ? 17 : 34);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BusinessCars) {
            BusinessCars car = (BusinessCars) obj;
            return (getManufacturer().equals(car.getManufacturer())) && getModel().equals(car.getModel()) && getColor().equals(car.getColor())
                    && getProductionDate().equals(car.getProductionDate()) && getEngine().equals(car.getEngine()) && getPower() == car.getPower() && personalDriver == car.personalDriver;
        }
        return false;
    }

    @Override
    public String toString() {
        return getManufacturer() + " " + getModel() + ", color: " + getColor() + ", produced in: " + getProductionDate() + ", " + getEngine().getDescription()
                + ", power: " + getPower() + ", PersonalDriver: " + personalDriver;
    }

    public BusinessCars(String manufacturer, String model, String productionDate, Engines engine, int power, boolean personalDriver) {
        super(manufacturer, model, productionDate, "Black", engine, power);
        this.personalDriver = personalDriver;
    }
}
