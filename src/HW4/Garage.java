package HW4;

import java.util.Map;

public class Garage {
    private Map<Cars, Integer> carsInGarage;
    private int parkingPlaces;
    private int totalCarsInGarage = 0;

    public Garage(int parkingPlaces, Map<Cars, Integer> map) {
        if (parkingPlaces <= 0) {
            this.parkingPlaces = 0;
        } else {
            this.parkingPlaces = parkingPlaces;
        }
        this.carsInGarage = map;
    }

    public void printAllCarsInGarage() {
        for (Map.Entry<Cars, Integer> cars : carsInGarage.entrySet()) {
            System.out.println(cars.getKey().toString() + ", COUNT: " + cars.getValue());
        }
    }

    public int getTotalCarsInGarage() {
        return totalCarsInGarage;
    }

    public void parkCar(Cars car) {
        if (totalCarsInGarage < parkingPlaces) {
            if (carsInGarage.containsKey(car)) {
                carsInGarage.put(car, carsInGarage.get(car) + 1);
            } else {
                carsInGarage.put(car, 1);
            }
            System.out.println("Car parked successfully.");
            totalCarsInGarage += 1;
        } else {
            System.out.println("No free places! Try to find another garage.");
        }
    }

    public void leaveParking(Cars car) {
        if (carsInGarage.containsKey(car) && carsInGarage.get(car) > 1) {
            carsInGarage.put(car, carsInGarage.get(car) - 1);
            System.out.println("Car leaved garage.");
            totalCarsInGarage -= 1;
        } else if (carsInGarage.containsKey(car) && carsInGarage.get(car) == 1) {
            carsInGarage.remove(car);
            System.out.println("Car leaved garage.");
            totalCarsInGarage -= 1;
        } else {
            System.out.println("Such car not presented in garage! Try to look for in another garage!");
        }
    }

    public Integer getCarCountByType(Cars car) {
        return carsInGarage.get(car) == null ? 0 : carsInGarage.get(car);
    }
}
