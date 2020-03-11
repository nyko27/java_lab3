package ua.lviv.iot.dairyproducts.model;

public class IceCream extends AbstractDairyProduct {

    private String nameOfTaste;
    private int weightInGrams;
    private TypeOfIceCream typeOfIceCream;

    public String getNameOfTaste() {
        return nameOfTaste;
    }

    public void setNameOfTaste(String nameOfTaste) {
        this.nameOfTaste = nameOfTaste;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public TypeOfIceCream getTypeOfIceCream() {
        return typeOfIceCream;
    }

    public void setTypeOfIceCream(TypeOfIceCream typeOfIceCream) {
        this.typeOfIceCream = typeOfIceCream;
    }

    public IceCream(int warrantyPeriodInDays, double priceInUAH, String producer, String producingCountry,
            double fatContentInPercentage, String nameOfTaste, int weightInGrams, TypeOfIceCream typeOfIceCream) {
        super(warrantyPeriodInDays, priceInUAH, producer, producingCountry, fatContentInPercentage);
        this.nameOfTaste = nameOfTaste;
        this.weightInGrams = weightInGrams;
        this.typeOfIceCream = typeOfIceCream;

    }

}
