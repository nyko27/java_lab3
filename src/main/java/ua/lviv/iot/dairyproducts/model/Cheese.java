package ua.lviv.iot.dairyproducts.model;

public class Cheese extends AbstractDairyProduct {

    private double weightInGrams;
    private String nameOfCheese;

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(double weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public String getNameOfCheese() {
        return nameOfCheese;
    }

    public void setNameOfCheese(String nameOfCheese) {
        this.nameOfCheese = nameOfCheese;
    }

    public Cheese(int warrantyPeriodInDays, double priceInUAH, String producer, String producingCountry,
            double fatContentInPercentage, double weightInGrams, String nameOfCheese) {
        super(warrantyPeriodInDays, priceInUAH, producer, producingCountry, fatContentInPercentage);
        this.weightInGrams = weightInGrams;
        this.nameOfCheese = nameOfCheese;
    }

}
