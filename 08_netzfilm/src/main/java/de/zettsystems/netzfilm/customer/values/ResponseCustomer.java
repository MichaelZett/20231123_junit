package de.zettsystems.netzfilm.customer.values;

import java.util.Objects;

public class ResponseCustomer {

    private final String firstname;
    private final String lastname;
    private final String customerId;

    public ResponseCustomer(String firstname, String lastname, String customerId) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.customerId = customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseCustomer that = (ResponseCustomer) o;
        return customerId.equals(that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
