package HW4.Cars;

import java.util.HashMap;

public class PopulateGarage {
    public static void main(String[] args) {
        Cars car1 = new SportCars("VW", "PoloGT", "2015", "Red", Engines.DIESEL, 280, true);
        Cars car2 = new SportCars("LADA", "Granta Sedan", "2009", "Eggplant", Engines.PETROL, 85, false);
        Cars car21 = new SportCars("LADA", "Granta Sedan", "2009", "Eggplant", Engines.PETROL, 85, false);
        Cars car3 = new BusinessCars("Mercedes", "E-200", "2016", Engines.PETROL, 220, true);
        Cars car4 = new BusinessCars("Mercedes", "E-200", "2016", Engines.ELECTRIC, 200, true);
        Cars car5 = new AllTerrainCars("2012", Engines.GAS, 170, true);
        Cars car6 = new AllTerrainCars("2012", Engines.GAS, 170, false);
        Cars car7 = new Trucks("BELAZ", "B-117", "2006", "Yellow", Engines.PETROL, 300);
        Cars car71 = new Trucks("BELAZ", "B-117", "2006", "Yellow", Engines.PETROL, 300);
        Cars car8 = new Trucks("KAMAZ", "K-243", "2011", "Green", Engines.PETROL, 20);

        Garage garage = new Garage(8, new HashMap<>());

        garage.parkCar(car1);
        garage.leaveParking(car1);
        garage.leaveParking(car1);
        garage.parkCar(car1);
        garage.parkCar(car2);
        garage.parkCar(car21);
        garage.parkCar(car3);
        garage.parkCar(car4);
        garage.parkCar(car5);
        garage.parkCar(car6);
        garage.parkCar(car7);
        garage.parkCar(car8);
        garage.parkCar(car71);
        garage.leaveParking(car5);
        garage.leaveParking(car6);
        garage.parkCar(car8);
        garage.parkCar(car71);
        System.out.println();

        System.out.println("There is " + garage.getTotalCarsInGarage() + " car(s) in garage.(Total amount)");
        System.out.println("There is " + garage.getCarCountByType(car2) + " such car(s) in garage: " + car2.toString());
        System.out.println();

        System.out.println("CARS IN GARAGE: ");
        garage.printAllCarsInGarage();
    }
}
