package ua.lviv.iot.dairyproducts.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.dairyproducts.manager.BaseDairyProductsManagerTest;
import ua.lviv.iot.dairyproducts.model.AbstractDairyProduct;
import ua.lviv.iot.dairyproducts.writer.DairyProductsWriter;

public class DairyProductsWriterTest extends BaseDairyProductsManagerTest {

    private String path = "D:\\eclipse-workspace\\work\\path.csv";

    @BeforeEach
    public void setUp() {
        createCheeses();
    }

    @Test
    public void writeToFile() throws IOException {

        try (Writer writerToFile = new FileWriter(path)) {

            DairyProductsWriter writer = new DairyProductsWriter();
            writer.setProductWriter(writerToFile);
            writer.writeToFile(cheeses);
        }
    }

    @Test
    public void testWriting() throws IOException {
        try (Writer csvWriter = new StringWriter()) {

            DairyProductsWriter writer = new DairyProductsWriter();
            writer.setProductWriter(csvWriter);
            writer.writeToFile(cheeses);

            String writtenString = "";

            for (AbstractDairyProduct product : cheeses) {
                writtenString += product.getHeaders() + "," + product.toCSV() + "\r\n";
            }

            assertEquals(writtenString, writer.toString());

        }
    }

}
