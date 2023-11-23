package de.zettsystems.netzfilm.rent.application;

import de.zettsystems.netzfilm.rent.values.ResponseRent;

import java.util.List;

public interface RentService {
    ResponseRent createRent(String movieTitle, String customerName);

    List<ResponseRent> receiveAllRents();
}
