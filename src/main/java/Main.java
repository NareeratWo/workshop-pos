
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    private void start() {
        Catalog catalog = new InMemoryCatalog();
        Display display = new ConsoleDisplay();
        PointOfSale pointOfSale = new PointOfSale(catalog, display);
        String result = pointOfSale.onBarcode("123456789");
        System.out.println(result);
    }

}
