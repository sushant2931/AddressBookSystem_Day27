package com.bridgelabz.addressbook;

import java.util.*;
import java.util.function.Predicate;

public class AddressBook {
    ArrayList<PersonDetails> referenceBook = new ArrayList<PersonDetails>();
    public  HashMap<String, ArrayList<PersonDetails>> personsByCity = new HashMap<String, ArrayList<PersonDetails>>();
    public  HashMap<String, ArrayList<PersonDetails>> personsByState = new HashMap<String, ArrayList<PersonDetails>>();
    private int numOfContacts = 0;

    public void addPerson() {
        System.out.println("Enter Person details:");

        PersonDetails person = intake();
        boolean isDuplicate = referenceBook.stream().anyMatch(contact -> person.equals(contact));
        if(isDuplicate) {
            System.out.println("Duplicate data entry. discarded");
        }
        else{
            referenceBook.add(person);
            if(personsByCity.get(person.getCity()) == null) personsByCity.put(person.getCity(), new ArrayList<>());
            personsByCity.get(person.getCity()).add(person);
            if(personsByState.get(person.getState()) == null) personsByState.put(person.getState(), new ArrayList<>());
            personsByState.get(person.getState()).add(person);
        }

    }


    public void searchByCity(String city,String firstName) {
        Predicate<PersonDetails> searchPerson = (contact -> contact.getCity().equals(city)&& contact.getFirstName().equals(firstName));
        referenceBook.stream().filter(searchPerson).forEach(person -> output(person));
    }

    public void searchByState(String state, String firstName) {
        Predicate<PersonDetails> searchPerson = (contact -> contact.getState().equals(state)&& contact.getFirstName().equals(firstName));
        referenceBook.stream().filter(searchPerson).forEach(person -> output(person));
    }

    public void personsInCity(String city) {
        ArrayList<PersonDetails> list = personsByCity.get(city);
        list.stream().forEach(person -> output(person));
    }

    public void personsInState(String State) {
        ArrayList<PersonDetails> list = personsByState.get(State);
        list.stream().forEach(person -> output(person));
    }

    public int countByCity(String city) {

        return (personsByCity.get(city)==null)?0:personsByCity.get(city).size();
    }
    public int countByState(String state) {
        return personsByState.get(state)==null?0:personsByState.get(state).size();
    }

    public void editPerson(String name) {
        int i=0;
        for(i=0;i<referenceBook.size();i++) {
            if(name.equals(referenceBook.get(i).getFirstName())) break;
        }
        if(i == referenceBook.size()) {
            System.out.println("name not found");
            return;
        }
        System.out.println("Changing details, Enter new details  of "+name);
        referenceBook.add(intake());
    }

    public void display() {
        Scanner sc = new Scanner(System.in);
        PersonDetails person = null;
        System.out.println("Persons present in the address book:");
        for(int i=0; i<referenceBook.size();i++) {
            System.out.print(referenceBook.get(i).getFirstName()+"  ");
        }
        System.out.println();
        System.out.println("Enter name to see details");
        String name = sc.next();

        for(int i = 0;i<referenceBook.size();i++) {
            if(referenceBook.get(i).getFirstName().equals(name)) {
                person = referenceBook.get(i);
                break;
            }
        }
        if(person == null) {
            System.out.println("name not found!");
            return;
        }

        output(person);

    }


    public void deletePerson(String name) {
        int i=0;
        for(i=0;i<referenceBook.size();i++) {
            if(referenceBook.get(i).getFirstName().equals(name)) {
                break;
            }
        }
        if(i==numOfContacts) {
            System.out.println("Name not found");
            return;
        }
        referenceBook.remove(i);
        System.out.println("Deleted details of : "+ name);
    }




    private static PersonDetails intake() {
        Scanner sc = new Scanner(System.in);
        PersonDetails person1 = new PersonDetails();

        System.out.println("Enter firstName:");
        person1.setFirstName(sc.next());
        System.out.println("Enter SecondName:");
        person1.setLastName(sc.next());
        System.out.println("Enter Address:");
        person1.setAddress(sc.next());
        System.out.println("Enter City:");
        person1.setCity(sc.next());
        System.out.println("Enter State:");
        person1.setState(sc.next());
        System.out.println("Enter Pin code:");
        person1.setPinCode(sc.nextInt());
        System.out.println("Enter Phone nmber:");
        person1.setPhoneNumber(sc.next());
        System.out.println("Enter email:");
        person1.setEmail(sc.next());
        return person1;
    }

    private static void output(PersonDetails person) {
        System.out.println("firstName : "+person.getFirstName());
        System.out.println("SecondName : "+ person.getLastName());
        System.out.println("Address : "+ person.getAddress());
        System.out.println("City : "+person.getCity());
        System.out.println("State : "+person.getState());
        System.out.println("Pin code : "+person.getPinCode());
        System.out.println("Phone nmber : "+person.getPhoneNumber() );
        System.out.println("email : "+person.getEmail());
    }
    public  void sortByFirstName() {
        referenceBook.stream()
                .sorted((contact1,contact2) -> contact1.getFirstName().compareTo(contact2.getFirstName()))
                .forEach(System.out::println);
    }
}
