package de.zettsystems.netzfilm.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import java.util.UUID;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long technicalKey;
    @Version
    private Long version;
    private String customerId;
    private String lastname;
    private String firstname;

    // needed for JPA
    Customer() {
        super();
    }

    public Customer(String firstname, String lastname) {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        this.customerId = UUID.randomUUID().toString();
    }

    public Long getTechnicalKey() {
        return technicalKey;
    }

    public Long getVersion() {
        return version;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void updateData(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
