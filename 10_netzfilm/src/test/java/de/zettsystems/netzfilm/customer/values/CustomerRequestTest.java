package de.zettsystems.netzfilm.customer.values;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerRequestTest {

    @Test
    void shouldHaveWorkingGettersAndConstructor() {
        CustomerRequest testee = new CustomerRequest("Peter", "Petersen");

        assertEquals("Peter", testee.getFirstname());
        assertEquals("Petersen", testee.getLastname());
    }
}