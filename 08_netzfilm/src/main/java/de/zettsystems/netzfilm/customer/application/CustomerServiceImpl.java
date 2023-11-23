package de.zettsystems.netzfilm.customer.application;

import de.zettsystems.netzfilm.customer.domain.Customer;
import de.zettsystems.netzfilm.customer.domain.CustomerRepository;
import de.zettsystems.netzfilm.customer.values.ResponseCustomer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository movieRepository) {
        this.customerRepository = movieRepository;
    }

    @Override
    public String createCustomer(String firstname, String lastname) {
        Customer customer = customerRepository.save(new Customer(firstname, lastname));
        return customer.getCustomerId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseCustomer> receiveAllCustomers() {
        return customerRepository.findAll().stream().map(this::createResponseFromCustomer).collect(Collectors.toList());
    }


    private ResponseCustomer createResponseFromCustomer(Customer customer) {
        return new ResponseCustomer(customer.getFirstname(), customer.getLastname(), customer.getCustomerId());
    }
}
