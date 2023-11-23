package de.zettsystems.netzfilm.customer.application;

import de.zettsystems.netzfilm.customer.domain.Customer;
import de.zettsystems.netzfilm.customer.domain.CustomerRepository;
import de.zettsystems.netzfilm.customer.values.ResponseCustomer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl testee;

    @Test
    void createCustomer() {
        final String firstname = "Peter";
        final String lastname = "Meyer";

        when(customerRepository.save(any(Customer.class))).then(AdditionalAnswers.returnsFirstArg());

        final String result = testee.createCustomer(firstname, lastname);
        assertThat(result).isNotEmpty();
    }

    @Test
    void receiveAllCustomer() {
        final String firstname = "Peter";
        final String lastname = "Meyer";
        final Customer customer = new Customer(firstname, lastname);
        final String firstname2 = "Petra";
        final String lastname2 = "Müller";
        final Customer customer2 = new Customer(firstname2, lastname2);

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer, customer2));

        final List<ResponseCustomer> result = testee.receiveAllCustomers();

        assertThat(result).isNotEmpty().hasSize(2);
        final ResponseCustomer responseCustomer = new ResponseCustomer(firstname, lastname, customer.getCustomerId());
        final ResponseCustomer responseCustomer2 = new ResponseCustomer(firstname2, lastname2, customer2.getCustomerId());

        assertThat(result).containsExactly(responseCustomer, responseCustomer2);
    }
}