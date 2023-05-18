package org.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Bootcamper {
    private String firstName;
    private String lastName;
    private ProgrammingLanguage programmingLanguage;
    private List<String> listOfCertificates = new ArrayList<String>();

    private String email;
    private String phoneNumber;

    public Bootcamper(String firstName, String lastName, ProgrammingLanguage programmingLanguage, List<String> listOfCertificates, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.programmingLanguage = programmingLanguage;
        this.listOfCertificates = listOfCertificates;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public List<String> getListOfCertificates() {
        return listOfCertificates;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public void setListOfCertificates(List<String> listOfCertificates) {
        this.listOfCertificates = listOfCertificates;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Bootcamper{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", programmingLanguage=" + programmingLanguage +
                ", listOfCertificates=" + listOfCertificates +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
