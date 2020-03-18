package ua.lviv.iot.dairyproducts.model;

public class Yoghurt extends AbstractDairyDrink {

    private Vitamins vitamins;

    public Vitamins getVitamins() {
        return vitamins;
    }

    public void setVitamins(Vitamins vitamins) {
        this.vitamins = vitamins;
    }

    public Yoghurt(int warrantyPeriodInDays, double priceInUAH, String producer, String producingCountry,
            double fatContentInPercentage, double volumeInLitres, Vitamins vitamins) {
        super(warrantyPeriodInDays, priceInUAH, producer, producingCountry, fatContentInPercentage, volumeInLitres);
        this.vitamins = vitamins;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "vitamins";
    }

    public String toCSV() {
        return super.toCSV() + "," + vitamins;
    }
}
