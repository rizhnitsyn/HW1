package HW4.Cars;

public class AllTerrainCars extends Cars {
    private boolean allWheelDrive;

    public boolean isAllWheelDrive() {
        return allWheelDrive;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 11 * result + 6 * getSumOfChars(getManufacturer());
        result = 11 * result + 6 * getSumOfChars(getModel());
        result = 11 * result + 6 * getSumOfChars(getColor()) + 6 * Integer.parseInt(getProductionDate());
        result = 11 * result + 6 * getSumOfChars(getEngine().getDescription()) + 6 * getPower();
        result = 11 * result + 6 * (allWheelDrive ? 17 : 34);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AllTerrainCars) {
            AllTerrainCars car = (AllTerrainCars) obj;
            return (getManufacturer().equals(car.getManufacturer())) && getModel().equals(car.getModel()) && getColor().equals(car.getColor())
                    && getProductionDate().equals(car.getProductionDate()) && getEngine().equals(car.getEngine()) && getPower() == car.getPower() && allWheelDrive == car.allWheelDrive;
        }
        return false;
    }

    @Override
    public String toString() {
        return getManufacturer() + " " + getModel() + ", color: " + getColor() + ", produced in: " + getProductionDate() + ", " + getEngine().getDescription()
                + ", power: " + getPower() + ", All-wheel-drive: " + allWheelDrive;
    }

    public AllTerrainCars(String productionDate, Engines engine, int power, boolean allWheelDrive) {
        super("UAZ", "WaterProof-3", productionDate, "Khaki", engine, power);
        this.allWheelDrive = allWheelDrive;
    }
}
