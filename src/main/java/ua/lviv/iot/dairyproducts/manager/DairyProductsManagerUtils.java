package ua.lviv.iot.dairyproducts.manager;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.dairyproducts.model.AbstractDairyProduct;
import ua.lviv.iot.dairyproducts.model.SortingType;

public class DairyProductsManagerUtils {

    // anonymous inner class

    private static Comparator<AbstractDairyProduct> producerNameComparator = new Comparator<AbstractDairyProduct>() {

        @Override
        public int compare(AbstractDairyProduct firstProduct, AbstractDairyProduct secondProduct) {
            return firstProduct.getProducer().compareTo(secondProduct.getProducer());
        }
    };

    public static void sortByProducerName(List<AbstractDairyProduct> dairyProducts, SortingType sortingType) {
        if (sortingType == SortingType.ASCENDING) {
            dairyProducts.sort(producerNameComparator);
        } else if (sortingType == SortingType.DESCENDING) {
            dairyProducts.sort(producerNameComparator.reversed());
        }
    }

    // static class sorting

    static class FatContentSorter implements Comparator<AbstractDairyProduct>, Serializable {

        private static final long serialVersionUID = 1L;

        @Override
        public int compare(AbstractDairyProduct firstProduct, AbstractDairyProduct secondProduct) {
            return (int) (firstProduct.getFatContentInPercentage() - secondProduct.getFatContentInPercentage());
        }

    }

    public static void sortByFatContent(List<AbstractDairyProduct> dairyProducts, SortingType sortingType) {

        if (sortingType == SortingType.ASCENDING) {
            dairyProducts.sort(new FatContentSorter());
        } else if (sortingType == SortingType.DESCENDING) {
            dairyProducts.sort(new FatContentSorter().reversed());
        }

    }
    // lambda function sorting

    static Comparator<AbstractDairyProduct> warrantyPeriodSorter = (AbstractDairyProduct firstProduct,
            AbstractDairyProduct secondProduct) -> firstProduct.getWarrantyPeriodInDays()
                    - secondProduct.getWarrantyPeriodInDays();

    public static void sortByWarrantyPeriod(List<AbstractDairyProduct> dairyProducts, SortingType sortingType) {
        if (sortingType == SortingType.ASCENDING) {
            dairyProducts.sort(warrantyPeriodSorter);
        } else if (sortingType == SortingType.DESCENDING) {
            dairyProducts.sort(warrantyPeriodSorter.reversed());
        }
    }

    // inner class sorting
    private class PriceInUAHSorter implements Comparator<AbstractDairyProduct> {

        @Override
        public int compare(AbstractDairyProduct firstProduct, AbstractDairyProduct secondProduct) {
            return (int) (firstProduct.getPriceInUAH() - secondProduct.getPriceInUAH());
        }
    }

    public static void sortByPrice(List<AbstractDairyProduct> dairyProducts, SortingType sortingType) {

        if (sortingType == SortingType.ASCENDING) {
            dairyProducts.sort(new DairyProductsManagerUtils().new PriceInUAHSorter());
        } else if (sortingType == SortingType.DESCENDING) {
            dairyProducts.sort(new DairyProductsManagerUtils().new PriceInUAHSorter().reversed());
        }
    }
}
