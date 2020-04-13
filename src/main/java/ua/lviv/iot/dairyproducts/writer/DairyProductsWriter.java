package ua.lviv.iot.dairyproducts.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import ua.lviv.iot.dairyproducts.model.AbstractDairyProduct;

public class DairyProductsWriter {

  private Writer productWriter;

  public void setProductWriter(Writer productWriter) {
    this.productWriter = productWriter;
  }

  public void writeToFile(List<AbstractDairyProduct> dairyProducts) throws IOException {

    String string;

    for (AbstractDairyProduct product : dairyProducts) {
      string = product.getHeaders() + "," + product.toCSV() + "\r\n";
      productWriter.write(string);
    }
    productWriter.flush();
  }

  public String toString() {
    return productWriter.toString();
  }
}
