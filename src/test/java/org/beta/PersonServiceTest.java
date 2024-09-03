package org.beta;

import static org.assertj.core.api.Assertions.assertThat;

import org.beta.curs16.comework.model.Person;
import org.beta.curs16.comework.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceTest {

    private List<Person> personList;
    private PersonService personService;

    @BeforeEach
    public void setup() {
        personList = new ArrayList<>();
        personList.add(new Person("John", "Doe", 28, "New York"));
        personList.add(new Person("Mihai", "Smith", 32, "Los Angeles"));
        personList.add(new Person("John", "Johnson", 24, "Oradea"));
        personList.add(new Person("Bob", "Brown", 45, "Houston"));
        personList.add(new Person("Charlie", "Williams", 35, "Phoenix"));
        personList.add(new Person("David", "Jones", 29, "Philadelphia"));
        personList.add(new Person("Eve", "Garcia", 31, "San Antonio"));
        personList.add(new Person("Frank", "Martinez", 26, "San Diego"));
        personList.add(new Person("Grace", "Rodriguez", 40, "Oradea"));
        personList.add(new Person("Henry", "Lee", 22, "Cluj"));
        personList.add(new Person("Isabel", "Walker", 37, "Austin"));
        personList.add(new Person("Jack", "Hall", 34, "Cluj"));
        personList.add(new Person("Karen", "Allen", 30, "Fort Worth"));
        personList.add(new Person("Leo", "Young", 27, "Columbus"));
        personList.add(new Person("Mia", "King", 25, "San Francisco"));
        personList.add(new Person("Nina", "Wright", 28, "Oradea"));
        personList.add(new Person("Oscar", "Lopez", 33, "Cluj"));
        personList.add(new Person("Paul", "Hill", 38, "Seattle"));
        personList.add(new Person("Quinn", "Scott", 29, "Cluj"));
        personList.add(new Person("Anna", "Green", 41, "Washington"));

        personService = new PersonService(personList);
    }

    @Test
    @DisplayName("INITIALIZE THE SERVICE WITHOUT A LIST AS A PARAMETER")
    public void initializeServiceWithNoParameter() {
        new PersonService();
    }

    @Test
    @DisplayName("INITIALIZE THE SERVICE WITH A LIST AS A PARAMETER")
    public void initializeServiceWithParameter() {
        new PersonService(personList);
    }

    @Test
    @DisplayName("GET ALL NAMES FORM THE LIST")
    public void getAllNamesTest() {
        List<String> result = personService.getAllNames();
        List<String> expectedNames = List.of(
                "John Doe", "Mihai Smith", "John Johnson", "Bob Brown",
                "Charlie Williams", "David Jones", "Eve Garcia",
                "Frank Martinez", "Grace Rodriguez", "Henry Lee",
                "Isabel Walker", "Jack Hall", "Karen Allen",
                "Leo Young", "Mia King", "Nina Wright",
                "Oscar Lopez", "Paul Hill", "Quinn Scott", "Anna Green"
        );

        assertThat(result).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("GET ALL MAJOR PERSONS")
    public void getMajorPersonsTest() {
        List<Person> result = personService.getMajorPersons();
        List<Person> expectedPersons = List.of(
                new Person("John", "Doe", 28, "New York"),
                new Person("Mihai", "Smith", 32, "Los Angeles"),
                new Person("John", "Johnson", 24, "Oradea"),
                new Person("Bob", "Brown", 45, "Houston"),
                new Person("Charlie", "Williams", 35, "Phoenix"),
                new Person("David", "Jones", 29, "Philadelphia"),
                new Person("Eve", "Garcia", 31, "San Antonio"),
                new Person("Frank", "Martinez", 26, "San Diego"),
                new Person("Grace", "Rodriguez", 40, "Oradea"),
                new Person("Henry", "Lee", 22, "Cluj"),
                new Person("Isabel", "Walker", 37, "Austin"),
                new Person("Jack", "Hall", 34, "Cluj"),
                new Person("Karen", "Allen", 30, "Fort Worth"),
                new Person("Leo", "Young", 27, "Columbus"),
                new Person("Mia", "King", 25, "San Francisco"),
                new Person("Nina", "Wright", 28, "Oradea"),
                new Person("Oscar", "Lopez", 33, "Cluj"),
                new Person("Paul", "Hill", 38, "Seattle"),
                new Person("Quinn", "Scott", 29, "Cluj"),
                new Person("Anna", "Green", 41, "Washington")
        );

        assertThat(result).isEqualTo(expectedPersons);
    }

    @Test
    @DisplayName("GET ALL PERSONS FROM ORADEA")
    public void getPersonsFromOradeaTest() {
        List<Person> result = personService.getPeopleFromOradea();
        List<Person> expectedPersons = List.of(
                new Person("John", "Johnson", 24, "Oradea"),
                new Person("Grace", "Rodriguez", 40, "Oradea"),
                new Person("Nina", "Wright", 28, "Oradea")
        );

        assertThat(result).isEqualTo(expectedPersons);
    }

    @Test
    @DisplayName("GET ALL PERSONS FROM ORADEA AND CLUJ")
    public void getPersonsFromOradeaAndClujTest() {
        List<Person> result = personService.getPeopleFromOradeaAndCluj();
        List<Person> expectedPersons = List.of(
                new Person("John", "Johnson", 24, "Oradea"),
                new Person("Grace", "Rodriguez", 40, "Oradea"),
                new Person("Henry", "Lee", 22, "Cluj"),
                new Person("Jack", "Hall", 34, "Cluj"),
                new Person("Nina", "Wright", 28, "Oradea"),
                new Person("Oscar", "Lopez", 33, "Cluj"),
                new Person("Quinn", "Scott", 29, "Cluj")
        );

        assertThat(result).isEqualTo(expectedPersons);
    }

    @Test
    @DisplayName("GET ALL NAMES FORM THE LIST CAPITALIZED")
    public void getAllNamesCapitalizedTest() {
        List<String> result = personService.getAllNamesCapitalized();
        List<String> expectedNames = List.of(
                "JOHN", "MIHAI", "JOHN", "BOB",
                "CHARLIE", "DAVID", "EVE",
                "FRANK", "GRACE", "HENRY",
                "ISABEL", "JACK", "KAREN",
                "LEO", "MIA", "NINA",
                "OSCAR", "PAUL", "QUINN", "ANNA"
        );

        assertThat(result).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("GET ALL NAMES FORM THE LIST ABREVIATED")
    public void getAllNamesAbreviatedTest() {
        List<String> result = personService.getNamesWithAbreviatedLastName();
        List<String> expectedNames = List.of(
                "John D.", "Mihai S.", "John J.", "Bob B.",
                "Charlie W.", "David J.", "Eve G.",
                "Frank M.", "Grace R.", "Henry L.",
                "Isabel W.", "Jack H.", "Karen A.",
                "Leo Y.", "Mia K.", "Nina W.",
                "Oscar L.", "Paul H.", "Quinn S.", "Anna G."
        );

        assertThat(result).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("GET PERSONS BETWEEN A AGE RANGE")
    public void getPersonsBetweenAgesTest() {
        List<Person> result = personService.getPersonsBetweenAges(40, 50);
        List<Person> expectedPersons = List.of(
                new Person("Bob", "Brown", 45, "Houston"),
                new Person("Anna", "Green", 41, "Washington")
        );

        assertThat(result).isEqualTo(expectedPersons);
    }

    @Test
    @DisplayName("GET PERSONS WHOSE FIRST NAME STARTS WITH 'A'")
    public void getPersonsThatFirstNameStartsWithATest() {
        List<Person> result = personService.getPersonsThatFirstNameStartsWithA();
        List<Person> expectedPersons = List.of(
                new Person("Anna", "Green", 41, "Washington")
        );

        assertThat(result).isEqualTo(expectedPersons);
    }

    @Test
    @DisplayName("GET ALL FIRST NAMES UNIQUELY")
    public void getAllFirstNamesUniquelyTest() {
        List<String> result = personService.getAllFirstNamesUniquely();
        List<String> expectedFirstNames = List.of(
                "John", "Mihai", "Bob", "Charlie", "David", "Eve",
                "Frank", "Grace", "Henry", "Isabel", "Jack", "Karen",
                "Leo", "Mia", "Nina", "Oscar", "Paul", "Quinn", "Anna"
        );

        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedFirstNames);
    }

    @Test
    @DisplayName("SORT PERSONS BY FIRST NAME")
    public void sortByFirstNameTest() {
        List<Person> result = personService.sortByFirstName();
        List<Person> expectedPersons = List.of(
                new Person("Anna", "Green", 41, "Washington"),
                new Person("Bob", "Brown", 45, "Houston"),
                new Person("Charlie", "Williams", 35, "Phoenix"),
                new Person("David", "Jones", 29, "Philadelphia"),
                new Person("Eve", "Garcia", 31, "San Antonio"),
                new Person("Frank", "Martinez", 26, "San Diego"),
                new Person("Grace", "Rodriguez", 40, "Oradea"),
                new Person("Henry", "Lee", 22, "Cluj"),
                new Person("Isabel", "Walker", 37, "Austin"),
                new Person("Jack", "Hall", 34, "Cluj"),
                new Person("John", "Doe", 28, "New York"),
                new Person("John", "Johnson", 24, "Oradea"),
                new Person("Karen", "Allen", 30, "Fort Worth"),
                new Person("Leo", "Young", 27, "Columbus"),
                new Person("Mia", "King", 25, "San Francisco"),
                new Person("Mihai", "Smith", 32, "Los Angeles"),
                new Person("Nina", "Wright", 28, "Oradea"),
                new Person("Oscar", "Lopez", 33, "Cluj"),
                new Person("Paul", "Hill", 38, "Seattle"),
                new Person("Quinn", "Scott", 29, "Cluj")
        );

        assertThat(result).isEqualTo(expectedPersons);
    }

    @Test
    @DisplayName("SORT PERSONS BY LAST NAME")
    public void sortByLastNameTest() {
        List<Person> result = personService.sortByLastName();
        List<Person> expectedPersons = List.of(
                new Person("Karen", "Allen", 30, "Fort Worth"),
                new Person("Bob", "Brown", 45, "Houston"),
                new Person("John", "Doe", 28, "New York"),
                new Person("Eve", "Garcia", 31, "San Antonio"),
                new Person("Anna", "Green", 41, "Washington"),
                new Person("Jack", "Hall", 34, "Cluj"),
                new Person("Paul", "Hill", 38, "Seattle"),
                new Person("John", "Johnson", 24, "Oradea"),
                new Person("David", "Jones", 29, "Philadelphia"),
                new Person("Mia", "King", 25, "San Francisco"),
                new Person("Henry", "Lee", 22, "Cluj"),
                new Person("Oscar", "Lopez", 33, "Cluj"),
                new Person("Frank", "Martinez", 26, "San Diego"),
                new Person("Grace", "Rodriguez", 40, "Oradea"),
                new Person("Quinn", "Scott", 29, "Cluj"),
                new Person("Mihai", "Smith", 32, "Los Angeles"),
                new Person("Isabel", "Walker", 37, "Austin"),
                new Person("Charlie", "Williams", 35, "Phoenix"),
                new Person("Nina", "Wright", 28, "Oradea"),
                new Person("Leo", "Young", 27, "Columbus")
        );

        assertThat(result).isEqualTo(expectedPersons);
    }

    @Test
    @DisplayName("SORT PERSONS BY FIRST NAME, THEN LAST NAME, THEN AGE")
    public void sortByNameAndAgeTest() {
        List<Person> result = personService.sortByNameAndAge();
        List<Person> expectedPersons = List.of(
                new Person("Anna", "Green", 41, "Washington"),
                new Person("Bob", "Brown", 45, "Houston"),
                new Person("Charlie", "Williams", 35, "Phoenix"),
                new Person("David", "Jones", 29, "Philadelphia"),
                new Person("Eve", "Garcia", 31, "San Antonio"),
                new Person("Frank", "Martinez", 26, "San Diego"),
                new Person("Grace", "Rodriguez", 40, "Oradea"),
                new Person("Henry", "Lee", 22, "Cluj"),
                new Person("Isabel", "Walker", 37, "Austin"),
                new Person("Jack", "Hall", 34, "Cluj"),
                new Person("John", "Doe", 28, "New York"),
                new Person("John", "Johnson", 24, "Oradea"),
                new Person("Karen", "Allen", 30, "Fort Worth"),
                new Person("Leo", "Young", 27, "Columbus"),
                new Person("Mia", "King", 25, "San Francisco"),
                new Person("Mihai", "Smith", 32, "Los Angeles"),
                new Person("Nina", "Wright", 28, "Oradea"),
                new Person("Oscar", "Lopez", 33, "Cluj"),
                new Person("Paul", "Hill", 38, "Seattle"),
                new Person("Quinn", "Scott", 29, "Cluj")
        );

        assertThat(result).isEqualTo(expectedPersons);
    }
}
