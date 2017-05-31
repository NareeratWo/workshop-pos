import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointOfSaleTest {

    @Test
    public void
    found_product_with_barcode_12345678() {
        Catalog catalog = new Catalog() {
            public Product findProductByBarcode(String barcode) {
                return new Product();
            }
        };
        Display display = new Display() {
            public String showPrice(double price) {
                return "500.00";
            }

            public String showNotFound() {
                return null;
            }
        };
        PointOfSale pointOfSale = new PointOfSale(catalog, display);
        String price = pointOfSale.onBarcode("12345678");
        assertEquals("500.00", price);
    }

    @Test
    public void
    not_found_product_with_barcode_123456789() {
        Catalog catalog = new Catalog() {
            public Product findProductByBarcode(String barcode) {
                return null;
            }
        };
        Display display = new Display() {
            public String showPrice(double price) {
                return null;
            }

            public String showNotFound() {
                return "Product not found";
            }
        };
        PointOfSale pointOfSale = new PointOfSale(catalog, display);
        String price = pointOfSale.onBarcode("123456789");
        assertEquals("Product not found", price);
    }

}
