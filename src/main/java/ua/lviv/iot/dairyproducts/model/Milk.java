package ua.lviv.iot.dairyproducts.model;

public class Milk extends AbstractDairyDrink {

	private double acidityInPH;

	public double getAcidityInPH() {
		return acidityInPH;
	}

	public void setAcidityInPH(double acidityInPH) {
		this.acidityInPH = acidityInPH;
	}

	public Milk(int warrantyPeriodInDays, double priceInUAH, String producer, String producingCountry,
			double fatContentInPercentage, double volumeInLitres, double acidityInPH) {
		super(warrantyPeriodInDays, priceInUAH, producer, producingCountry, fatContentInPercentage, volumeInLitres);
		this.acidityInPH = acidityInPH;
	}

}
