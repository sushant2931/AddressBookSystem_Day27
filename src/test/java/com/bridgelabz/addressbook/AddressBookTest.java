package com.bridgelabz.addressbook;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
    PersonDetails person1;
    PersonDetails person2;
    @Before
    public void initialize() {
        person1 = new PersonDetails();
        person1.setFirstName("Sushant");
        person1.setLastName("Lad");
        person1.setAddress("Sangli");
        person1.setCity("Pune");
        person1.setState("Maharashtra");
        person1.setPinCode(411043);
        person1.setPhoneNumber("8830602356");
        person1.setEmail("sushantlad@gmail.com");

        person2 = new PersonDetails();
        person2.setFirstName("Rajendra");
        person2.setLastName("Gund");
        person2.setAddress("Shirdi");
        person2.setCity("Ahmednagar");
        person2.setState("Maharashtra");
        person2.setPinCode(416307);
        person2.setPhoneNumber("8856043932");
        person2.setEmail("rajendra@gmail.com");
    }


    @Test
    public void givenAContact_WhenAddedToList_ShouldReturnCorrectSize() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(person1, IOService.LIST_DS_IO);
        addressBook.addPerson(person2, IOService.LIST_DS_IO);
        Assert.assertEquals(2,addressBook.referenceBook.size());
    }

    @Test
    public void givenAContact_WhenAddedToFile_ShouldReturnCorectSize() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(person1, IOService.TXT_FILE_IO);
        addressBook.addPerson(person2, IOService.TXT_FILE_IO);
        long size = 0;
        try {
            size = Files.lines(Paths.get("AddressBook-file.txt")).count();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2,size);
    }

    @Test
    public void whenCalled_ReadFromListMethod_ShouldPrintList() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(person1, IOService.LIST_DS_IO);
        addressBook.addPerson(person2, IOService.LIST_DS_IO);
        long size  = addressBook.readData(IOService.LIST_DS_IO);
        Assert.assertEquals(2,size);
    }

    @Test
    public void whenCalled_ReadFromFileMethod_ShouldPrintFile() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(person1, IOService.TXT_FILE_IO);
        addressBook.addPerson(person2, IOService.TXT_FILE_IO);
        long size  = addressBook.readData(IOService.TXT_FILE_IO);
        Assert.assertEquals(2,size);
    }
}
