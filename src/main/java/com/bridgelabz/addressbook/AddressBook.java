package com.bridgelabz.addressbook;

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<PersonDetails> referenceBook = new ArrayList<PersonDetails>();

    public void addPerson() {

        PersonDetails person1 = new PersonDetails();
        person1.setFirstName("Sushant");
        person1.setLastName("Lad");
        person1.setAddress("Kavalapur, Sangli");
        person1.setCity("Pune");
        person1.setState("Maharashtra");
        person1.setPinCode(411043);
        person1.setPhoneNumber("8830602356");
        person1.setEmail("sushantlad@gmail.com");
        referenceBook.add(person1);
    }
}
