package ua.lviv.iot.dairyproducts.model;

import javax.persistence.Entity;

@Entity
public class Cheese extends AbstractDairyProduct {

  private double weightInGrams;
  private String nameOfCheese;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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

  public Cheese() {

  }

  public String getHeaders() {
    return super.getHeaders() + "," + "weightInGrams,nameOfCheese";
  }

  public String toCSV() {
    return super.toCSV() + "," + weightInGrams + "," + nameOfCheese;
  }

}
