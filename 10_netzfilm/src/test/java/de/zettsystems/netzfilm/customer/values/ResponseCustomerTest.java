package de.zettsystems.netzfilm.customer.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResponseCustomerTest {

    @Test
    void shouldHaveWorkingGettersAndConstrcutor() {
        ResponseCustomer testee = new ResponseCustomer("Michael", "Mustermann", "ID");

        assertThat(testee.getCustomerId()).isEqualTo("ID");
        assertThat(testee.getFirstname()).isEqualTo("Michael");
        assertThat(testee.getLastname()).isEqualTo("Mustermann");
    }

}