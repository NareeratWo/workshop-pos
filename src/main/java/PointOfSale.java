interface Feature1 {
    String onBarcode(String barcode);
}

interface Feature2 {
    String onBarcode2(String barcode);
}


public class PointOfSale implements Feature1 {
    private final Catalog catalog;
    private final Display display;

    public PointOfSale(Catalog catalog, Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public String onBarcode(String barcode) {
        //Step 1
        Product product = catalog.findProductByBarcode(barcode);
        if(product!=null) {
            //Step 2
            return display.showPrice(product.getPrice());
        }
        return display.showNotFound();
    }
}
