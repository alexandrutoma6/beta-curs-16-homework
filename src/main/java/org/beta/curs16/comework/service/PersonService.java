package org.beta.curs16.comework.service;

import org.beta.curs16.comework.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    private final List<Person> persons;

    public PersonService(List<Person> persons) {
        this.persons = new ArrayList<>(persons);
    }

    public PersonService() {
        this.persons = new ArrayList<>();
    }

    public List<String> getAllNames() {
        return persons.stream()
                .map(person -> person.firstName() + " " + person.lastName())
                .toList();
    }

    public List<Person> getMajorPersons() {
        return persons.stream()
                .filter(person -> person.age() >= 18)
                .toList();
    }

    public List<Person> getPeopleFromOradea() {
        return persons.stream()
                .filter(person -> person.city().equals("Oradea"))
                .toList();
    }

    public List<Person> getPeopleFromOradeaAndCluj() {
        return persons.stream()
                .filter(person -> person.city().equals("Oradea") || person.city().equals("Cluj"))
                .toList();
    }

    public List<String> getAllNamesCapitalized() {
        return persons.stream()
                .map(person -> person.firstName().toUpperCase())
                .toList();
    }

    public List<String> getNamesWithAbreviatedLastName() {
        return persons.stream()
                .map(person -> person.firstName() + " " + person.lastName().charAt(0) + ".")
                .toList();
    }

    public List<Person> getPersonsBetweenAges(int min, int max) {
        return persons.stream()
                .filter(person -> person.age() > min && person.age() < max)
                .toList();
    }

    public List<Person> getPersonsThatFirstNameStartsWithA(){
        return persons.stream()
                .filter(person -> person.firstName().charAt(0) == 'A')
                .toList();
    }

    public List<String> getAllFirstNamesUniquely(){
        return persons.stream()
                .map(Person::firstName)
                .distinct()
                .toList();
    }

    public List<Person> sortByFirstName(){
        return persons.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .toList();
    }

    public List<Person> sortByLastName(){
        return persons.stream()
                .sorted(Comparator.comparing(Person::lastName))
                .toList();
    }

    public List<Person> sortByNameAndAge() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::firstName)
                        .thenComparing(Person::lastName)
                        .thenComparingInt(Person::age))
                .toList();
    }
}
