package org.example.model;

import java.time.LocalDate;
import java.time.Period;

public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String mailingAddress;
    private LocalDate dateOfBirth;

    public Patient(int id, String firstName, String lastName, String phoneNumber,
                   String email, String mailingAddress, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.mailingAddress = mailingAddress;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    // Getters
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getMailingAddress() { return mailingAddress; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setMailingAddress(String mailingAddress) { this.mailingAddress = mailingAddress; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
}