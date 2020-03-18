package ua.lviv.iot.dairyproducts.model;

public class Kefir extends AbstractDairyDrink {

    private String cereals;

    public String getCereals() {
        return cereals;
    }

    public void setCereals(String cereals) {
        this.cereals = cereals;
    }

    public Kefir(int warrantyPeriodInDays, double priceInUAH, String producer, String producingCountry,
            double fatContentInPercentage, double volumeInLitres, String cereals) {
        super(warrantyPeriodInDays, priceInUAH, producer, producingCountry, fatContentInPercentage, volumeInLitres);
        this.cereals = cereals;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "cereals";
    }

    public String toCSV() {
        return super.toCSV() + "," + cereals;
    }
}
