package de.zettsystems.netzfilm.customer.adapter;

import de.zettsystems.netzfilm.customer.application.CustomerService;
import de.zettsystems.netzfilm.customer.values.CustomerRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerAdapterTest {
    static final String MAX = "Max";
    static final String MUSTERMANN = "Mustermann";
    static final String CUSTOMER_ID = "ID";
    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerAdapter testee;

    @Test
    void shouldCreateCustomer() {
        CustomerRequest customerRequest = createCustomerRequest();
        when(customerService.createCustomer(MAX, MUSTERMANN)).thenReturn(CUSTOMER_ID);

        ResponseEntity<String> result = testee.createCustomer(customerRequest);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(CUSTOMER_ID, result.getBody());
    }

    @Test
    void shouldRetrieveAllCustomers() {
        testee.listCustomers();

        verify(customerService).receiveAllCustomers();
    }

    static CustomerRequest createCustomerRequest() {
        return new CustomerRequest(MAX, MUSTERMANN);
    }
}