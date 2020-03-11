package ua.lviv.iot.dairyproducts.manager;

import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.dairyproducts.model.AbstractDairyProduct;

public class DairyProductsManager {

    private List<AbstractDairyProduct> dairyProducts;

    public DairyProductsManager() {
        super();
        dairyProducts = new LinkedList<AbstractDairyProduct>();
    }

    public void addDairyProducts(List<AbstractDairyProduct> dairyProducts) {
        this.dairyProducts.addAll(dairyProducts);
    }

    public void addDairyProduct(AbstractDairyProduct dairyProduct) {
        this.dairyProducts.add(dairyProduct);
    }

    public List<AbstractDairyProduct> findPorductsWithPriceHigherThan(double priceInUAH) {
        List<AbstractDairyProduct> result = new LinkedList<>();
        for (AbstractDairyProduct product : dairyProducts) {
            if (product.getPriceInUAH() > priceInUAH) {
                result.add(product);
            }
        }
        return result;
    }
}
