package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Rukshesh", Gender.FEMALE),
                new Person("Himanshi", Gender.MALE),
                new Person("Rahil", Gender.FEMALE),
                new Person("Trijal", Gender.MALE),
                new Person("Netik", Gender.MALE)
        );

        //Imperative approach - Has a lot of code for something simple
        System.out.println("// Imperative Approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }


        //Declarative Approach
        System.out.println("// Declarative Approach");

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        List<Person> femalesDeclarative = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        femalesDeclarative.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
