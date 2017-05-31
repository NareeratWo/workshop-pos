import java.util.HashMap;
import java.util.Map;

public class InMemoryCatalog implements Catalog {
    public Product findProductByBarcode(String barcode) {
        Map<String, Product> products
                = new HashMap<String, Product>();
        products.put("12345678", new Product());

        return products.get(barcode);
    }
}
