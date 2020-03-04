package ua.lviv.iot.dairyproducts.manager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.dairyproducts.model.AbstractDairyProduct;

class DairyProductsManagerTest extends BaseDairyProductsManagerTest {

	private DairyProductsManager dairyProductsManager;

	@BeforeEach
	public void setUp() {
		dairyProductsManager = new DairyProductsManager();
		createIceCreams();
		dairyProductsManager.addDairyProducts(iceCreams);
	}

	@Test
	public void testFindPorductsWithPriceHigherThan() {
		List<AbstractDairyProduct> dairyProducts = dairyProductsManager.findPorductsWithPriceHigherThan(20);

		assertEquals(1, dairyProducts.size());
	}

}