package com.umesh.tests.flightreservation.model;

import java.util.Objects;

public final class FlightReservationTestData {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private  String street;
    private  String city;
    private  String zip;
    private  String passengersCount;
    private  String expectedPrice;

    public FlightReservationTestData() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getPassengersCount() {
        return passengersCount;
    }

    public String getExpectedPrice() {
        return expectedPrice;
    }
}
