package com.enviro.assessment.grad001.sicelozitha.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "investors")
public class Investor {
    @Id
    @Column(name = "investor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long investorId;
    @Column(name = "investor_name")
    private String firstName;
    @Column(name = "investor_surname")
    private String lastName;
    @Column(name = "investor_address")
    private String address;
    @Column(name = "investor_contact")
    private int contact;
    @Column(name = "investor_dob")
    private LocalDate dob;
    // Add address and contact fields
    @OneToMany(mappedBy = "investor")
    private List<Product> products;
    // Getters and setters
    public Investor() {
    }

    public Investor(String firstName, String lastName, String address, int contact, LocalDate dob, List<Product> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.products = products;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getContact() {
        return contact;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    //return age by using dob
    public int age(){
        LocalDate currentDate = LocalDate.now();
        return Period.between(dob, currentDate).getYears();
    }
}
