package org.beta.curs16.comework.service;

import org.beta.curs16.comework.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {

    private final List<Person> persons;

    public PersonService(List<Person> persons) {
        this.persons = new ArrayList<>(persons);
    }

    public List<String> getAllNames() {
        return persons.stream()
                .map(person -> person.firstName() + " " + person.lastName())
                .collect(Collectors.toList());
    }

    public List<Person> getMajorPersons() {
        return persons.stream()
                .filter(person -> person.age() >= 18)
                .toList();
    }

    public List<Person> getPeopleFromOradea(){
        return persons.stream()
                .filter(person -> person.city().equals("Oradea"))
                .toList();
    }

    public List<Person> getPeopleFromOradeaAndCluj(){
        return persons.stream()
                .filter(person -> person.city().equals("Oradea") || person.city().equals("Cluj"))
                .toList();
    }

    public List<String> getAllNamesCapitalized(){
        return persons.stream()
                .map(person -> person.firstName().toUpperCase())
                .toList();
    }

}
