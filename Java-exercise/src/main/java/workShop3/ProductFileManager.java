package workShop3;
import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ProductFileManager {
    private static final String FILE = "products.csv";

    public ArrayList<Product> loadProduct() {
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String sku = parts[0];
                String productName = parts[1];
                BigDecimal price = new BigDecimal(parts[2]);
                String department = parts[3];

                Product product = new Product(
                        sku,
                        productName,
                        price,
                        department
                );
                products.add(product);
            }

        } catch (IOException e) {
            System.out.println("Error reading products: " + e.getMessage());
        }
        return products;
    }
}
