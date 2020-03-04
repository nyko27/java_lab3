package ua.lviv.iot.dairyproducts.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.dairyproducts.model.SortingType;

public class DairyProductsManagerUtilsTest extends BaseDairyProductsManagerTest {

	private DairyProductsManager dairyProductsManager;

	@BeforeEach
	public void setUp() {
		dairyProductsManager = new DairyProductsManager();
		createCheeses();
		dairyProductsManager.addDairyProducts(cheeses);
	}

	@Test
	public void testSortingAscending() {
		DairyProductsManagerUtils.sortByFatContent(cheeses, SortingType.ASCENDING);

		assertEquals(25, cheeses.get(0).getFatContentInPercentage());
		assertEquals(32, cheeses.get(1).getFatContentInPercentage());
		assertEquals(40, cheeses.get(2).getFatContentInPercentage());
	}

	@Test
	public void testSortingDescending() {
		DairyProductsManagerUtils.sortByWarrantyPeriod(cheeses, SortingType.DESCENDING);

		assertEquals(40, cheeses.get(0).getFatContentInPercentage());
		assertEquals(35, cheeses.get(1).getFatContentInPercentage());
		assertEquals(30, cheeses.get(2).getFatContentInPercentage());
	}

}
