package model;

import interfaces.Printable;

public class Contact implements Printable {

    private String id;
    private String phoneNumber;
    private String firstName;
    private String experience;

    public Contact(String id, String phoneNumber, String firstName, String experience) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.experience = experience;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Contact contact = (Contact) obj;

        return id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public void print() {
        System.out.println(this.id + " " + this.phoneNumber + " " + this.firstName + " " + this.experience);
    }
}