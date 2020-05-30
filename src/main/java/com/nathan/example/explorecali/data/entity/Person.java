package com.nathan.example.explorecali.data.entity;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class Person {
    private String firstName;
    private String lastName;
    private Date datOfBirth;
    private String email;
    private Address address;

    public Person() {}

    public Person(String firstName, String lastName, Date datOfBirth, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.datOfBirth = datOfBirth;
        this.email = email;
        this.address = address;
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

    public Date getDatOfBirth() {
        return datOfBirth;
    }

    public void setDatOfBirth(Date datOfBirth) {
        this.datOfBirth = datOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", datOfBirth=" + datOfBirth +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
