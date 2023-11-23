package de.zettsystems.netzfilm.customer.values;

public class CustomerRequest {
    private final String firstname;
    private final String lastname;

    public CustomerRequest(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
