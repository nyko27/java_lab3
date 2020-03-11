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

        DairyProductsManagerUtils.sortByPrice(cheeses, SortingType.ASCENDING);

        assertEquals(110, cheeses.get(0).getPriceInUAH());
        assertEquals(135.5, cheeses.get(1).getPriceInUAH());
        assertEquals(150, cheeses.get(2).getPriceInUAH());
    }

    @Test
    public void testSortingDescending() {
        DairyProductsManagerUtils.sortByWarrantyPeriod(cheeses, SortingType.DESCENDING);

        assertEquals(40, cheeses.get(0).getWarrantyPeriodInDays());
        assertEquals(35, cheeses.get(1).getWarrantyPeriodInDays());
        assertEquals(30, cheeses.get(2).getWarrantyPeriodInDays());

        DairyProductsManagerUtils.sortByProducerName(cheeses, SortingType.DESCENDING);

        assertEquals("Prostokvasheno", cheeses.get(0).getProducer());
        assertEquals("Molokiya", cheeses.get(1).getProducer());
        assertEquals("Galychyna", cheeses.get(2).getProducer());

    }
}
