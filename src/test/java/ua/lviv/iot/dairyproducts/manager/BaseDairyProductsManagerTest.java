package ua.lviv.iot.dairyproducts.manager;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import ua.lviv.iot.dairyproducts.model.AbstractDairyProduct;
import ua.lviv.iot.dairyproducts.model.Cheese;
import ua.lviv.iot.dairyproducts.model.IceCream;
import ua.lviv.iot.dairyproducts.model.TypeOfIceCream;

public abstract class BaseDairyProductsManagerTest {

	protected List<AbstractDairyProduct> cheeses;
	protected List<AbstractDairyProduct> iceCreams;

	public void createCheeses() {
		cheeses = new LinkedList<AbstractDairyProduct>();
		cheeses.add(new Cheese(30, 135.5, "Molokiya", "Ukarine", 25, 200, "mozzarella"));
		cheeses.add(new Cheese(40, 110, "Galychyna", "Ukarine", 32, 150, "parmesan"));
		cheeses.add(new Cheese(35, 150, "Prostokvasheno", "Ukarine", 40, 250, "Brie"));
	}

	public void createIceCreams() {
		iceCreams = new LinkedList<AbstractDairyProduct>();
		iceCreams.add(new IceCream(100, 15, "Lasunka", "Ukarine", 19, "melon", 100, TypeOfIceCream.ON_STICK));
		iceCreams.add(new IceCream(130, 24, "Limo", "Ukarine", 15, "strawberry", 90, TypeOfIceCream.IN_CUP));
		iceCreams.add(new IceCream(70, 10.5, "Hladoprom", "Ukarine", 12, "chocolate", 120, TypeOfIceCream.ON_STICK));
	}

	protected abstract void setUp();
}
