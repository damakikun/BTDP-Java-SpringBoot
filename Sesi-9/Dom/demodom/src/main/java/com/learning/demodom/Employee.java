package com.learning.demodom;

public class Employee {
    private Integer id;
    private String firstName, lastName, location;

    @Override
    public String toString() {
        return "Employee [id= " + id + ", Nama Depan: " + firstName + ", Nama Belakang: " + lastName + ", Lokasi: "
                + location + "]";

    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }

}