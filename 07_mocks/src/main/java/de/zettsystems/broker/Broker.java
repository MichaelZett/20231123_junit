package de.zettsystems.broker;

public class Broker {
    private StockService stockService;

    public Broker(StockService stockService) {
        this.stockService = stockService;
    }

    public void buyBestStock(int value) {
        // Objekterzeugung, Objekt wird nicht zurückgegeben (void)
        Stock sap = new Stock("123", "SAP", 1);

        // Preisermittlung können wir mocken
        final double price = stockService.getPrice(sap);

        // Berechnungsergebnis, wird nicht zurückgegeben (void)
        final int quantity = (int) (value / price);

        // wir müssen den Mock befragen: welche Aktie, welche quantity
        stockService.buy(sap, quantity);
    }
}
