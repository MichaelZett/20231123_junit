package de.zettsystems.netzfilm.customer.application;

import de.zettsystems.netzfilm.customer.values.ResponseCustomer;

import java.util.List;

public interface CustomerService {
    String createCustomer(String firstname, String lastname);

    List<ResponseCustomer> receiveAllCustomers();
}
