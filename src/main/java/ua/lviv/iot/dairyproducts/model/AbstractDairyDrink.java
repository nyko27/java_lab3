package ua.lviv.iot.dairyproducts.model;

public abstract class AbstractDairyDrink extends AbstractDairyProduct {

  protected double volumeInLitres;

  public double getVolumeInLitres() {
    return volumeInLitres;
  }

  public void setVolumeInLitres(double volumeInLitres) {
    this.volumeInLitres = volumeInLitres;
  }

  public AbstractDairyDrink(int warrantyPeriodInDays, double priceInUAH, String producer, String producingCountry,
      double fatContentInPercentage, double volumeInLitres) {
    super(warrantyPeriodInDays, priceInUAH, producer, producingCountry, fatContentInPercentage);
    this.volumeInLitres = volumeInLitres;
  }

  public String getHeaders() {
    return super.getHeaders() + "," + "volumeInLitres";
  }

  public String toSCV() {
    return super.toCSV() + "," + volumeInLitres;
  }

}
