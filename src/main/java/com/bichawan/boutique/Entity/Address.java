package com.bichawan.boutique.Entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "ADDRESS_MASTER")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_MASTER_ID" , updatable = false, nullable = false)
    private int addressMasterId;

    @Column(name = "STREET_ADDRESS")
    private String streetAddress;

    @Pattern(regexp = "[\\d]{6}")
    @Column(name = "PIN_CODE")
    private String pinCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;


    public Address(Integer addressMasterId, String streetAddress, String pinCode, String city, String state) {
        this.addressMasterId = addressMasterId;
        this.streetAddress = streetAddress;
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
    }

    public Address() {
    }

    public int getAddressMasterId() {
        return addressMasterId;
    }

    public void setAddressMasterId(int addressMasterId) {
        this.addressMasterId = addressMasterId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressMasterId=" + addressMasterId +
                ", streetAddress='" + streetAddress + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
