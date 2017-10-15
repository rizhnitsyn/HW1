package HW4.Cars;

public abstract class Cars {
    private String manufacturer;
    private String model;
    private String productionDate;
    private String color;
    private Engines engine;
    private int power;

    public int getSumOfChars(String analysedString) {
        char[] charArrayr = analysedString.toCharArray();
        int amount = 0;
        for (char ch : charArrayr) {
            amount += (int) ch;
        }
        return amount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public String getColor() {
        return color;
    }

    public Engines getEngine() {
        return engine;
    }

    public int getPower() {
        return power;
    }

    public Cars(String manufacturer, String model, String productionDate, String color, Engines engine, int power) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionDate = productionDate;
        this.color = color;
        this.engine = engine;
        this.power = power;
    }
}
