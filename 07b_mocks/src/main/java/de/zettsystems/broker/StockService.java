package de.zettsystems.broker;

public interface StockService {
    double getPrice(Stock stock);

    void buy(Stock stock, int quantity);
}
