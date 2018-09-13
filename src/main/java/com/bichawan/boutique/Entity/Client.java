package com.bichawan.boutique.Entity;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Table(name = "CLIENT_MASTER")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_MASTER_ID" , nullable = false, updatable = false)
    private int clientMasterId;

    @NotEmpty(message = "Name should not be Empty")
    @NotBlank(message = "Name should not have white Spaces")
    @Column(name = "FIRST_NAME" , nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @NotEmpty(message = "Mobile Number should not be Empty Or Null")
    @NotBlank(message = "Mobile Number should not have white Spaces")
    @Pattern(regexp = "[\\d]{10}")
    @Column(name = "MOBILE_NUMBER" , nullable = false)
    private String mobileNumber;


    @Email (message = "Please Enter a valid Email Address")
    @Column(name = "EMAIL")
    private String email;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_MASTER_ID")
    private Address address;

    public Client() {

    }

    public Client(int clientMasterId, String firstName, String lastName, String mobileNumber, String email, Address address) {
        this.clientMasterId = clientMasterId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.address = address;
    }


    public int getClientMasterId() {
        return clientMasterId;
    }

    public void setClientMasterId(int clientMasterId) {
        this.clientMasterId = clientMasterId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return  false;
        }
        if (!(obj instanceof Client)) {
            return false;
        }
        Client client = (Client) obj;
        return client.getClientMasterId() == this.getClientMasterId();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Client{" +
                "clientMasterId=" + clientMasterId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
