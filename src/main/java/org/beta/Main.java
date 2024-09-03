package org.beta;

import org.beta.curs16.comework.model.Person;
import org.beta.curs16.comework.service.PersonService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> list = generatePersonList();
        PersonService service = new PersonService(list);

        System.out.println(service.getAllNames());
        System.out.println(service.getMajorPersons());
        System.out.println(service.getPeopleFromOradea());
        System.out.println(service.getPeopleFromOradeaAndCluj());
        System.out.println(service.getAllNamesCapitalized());
        System.out.println(service.getNamesWithAbreviatedLastName());
        System.out.println(service.getPersonsBetweenAges(18,40));
        System.out.println(service.getPersonsThatFirstNameStartsWithA());
        System.out.println(service.getAllFirstNamesUniquely());
        System.out.println(service.sortByFirstName());
        System.out.println(service.sortByLastName());
        System.out.println(service.sortByNameAndAge());
    }

    private static List<Person> generatePersonList() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("John", "Doe", 28, "New York"));
        list.add(new Person("Mihai", "Smith", 32, "Los Angeles"));
        list.add(new Person("John", "Johnson", 24, "Oradea"));
        list.add(new Person("Bob", "Brown", 45, "Houston"));
        list.add(new Person("Charlie", "Williams", 35, "Phoenix"));
        list.add(new Person("David", "Jones", 29, "Philadelphia"));
        list.add(new Person("Eve", "Garcia", 31, "San Antonio"));
        list.add(new Person("Frank", "Martinez", 26, "San Diego"));
        list.add(new Person("Grace", "Rodriguez", 40, "Oradea"));
        list.add(new Person("Henry", "Lee", 22, "Cluj"));
        list.add(new Person("Isabel", "Walker", 37, "Austin"));
        list.add(new Person("Jack", "Hall", 34, "Cluj"));
        list.add(new Person("Karen", "Allen", 30, "Fort Worth"));
        list.add(new Person("Leo", "Young", 27, "Columbus"));
        list.add(new Person("Mia", "King", 25, "San Francisco"));
        list.add(new Person("Nina", "Wright", 28, "Oradea"));
        list.add(new Person("Oscar", "Lopez", 33, "Cluj"));
        list.add(new Person("Paul", "Hill", 38, "Seattle"));
        list.add(new Person("Quinn", "Scott", 29, "Cluj"));
        list.add(new Person("Anna", "Green", 41, "Washington"));

        return list;
    }
}