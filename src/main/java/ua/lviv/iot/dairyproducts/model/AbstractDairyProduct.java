package ua.lviv.iot.dairyproducts.model;

public abstract class AbstractDairyProduct {

    protected int warrantyPeriodInDays;
    protected double priceInUAH;
    protected String producer;
    protected String producingCountry;
    protected double fatContentInPercentage;

    public AbstractDairyProduct(int warrantyPeriodInDays, double priceInUAH, String producer, String producingCountry,
            double fatContentInPercentage) {
        super();
        this.warrantyPeriodInDays = warrantyPeriodInDays;
        this.priceInUAH = priceInUAH;
        this.producer = producer;
        this.producingCountry = producingCountry;
        this.fatContentInPercentage = fatContentInPercentage;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public double getFatContentInPercentage() {
        return fatContentInPercentage;
    }

    public void setFatContentInPercentage(double fatContentInPercentage) {
        this.fatContentInPercentage = fatContentInPercentage;
    }

    public double getPriceInUAH() {
        return priceInUAH;
    }

    public void setPriceInUAH(double priceInUAH) {
        this.priceInUAH = priceInUAH;
    }

    public int getWarrantyPeriodInDays() {
        return warrantyPeriodInDays;
    }

    public void setWarrantyPeriodInDays(int warrantyPeriodInDays) {
        this.warrantyPeriodInDays = warrantyPeriodInDays;
    }

    public String getHeaders() {
        return "warrantyPeriodInDays,priceInUAH,producer,producingCountry,fatContentInPercentage";
    }

    public String toCSV() {
        return warrantyPeriodInDays + "," + priceInUAH + "," + producer + "," + producingCountry + ","
                + fatContentInPercentage;
    }

}
