package de.zettsystems.netzfilm.customer.adapter;

import de.zettsystems.netzfilm.customer.application.CustomerService;
import de.zettsystems.netzfilm.customer.values.CustomerRequest;
import de.zettsystems.netzfilm.customer.values.ResponseCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerAdapter {
    private final CustomerService customerService;

    public CustomerAdapter(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/customers/")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerRequest customer) {
        String newCustomerId = customerService.createCustomer(customer.getFirstname(), customer.getLastname());
        return new ResponseEntity<>(newCustomerId, HttpStatus.CREATED);
    }

    @GetMapping(path = "/customers/")
    public List<ResponseCustomer> listCustomers() {
        return customerService.receiveAllCustomers();
    }
}
