package streams;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Rukshesh", FEMALE),
                new Person("Himanshi", MALE),
                new Person("Rahil", FEMALE),
                new Person("Trijal", MALE),
                new Person("Netik", MALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        /**
         * Leave the LHS assignment variable and
         * just use the RHS of these 3 lines of code inside stream methods
         */
//        //Function takes a Person Class and produces a String
//        Function<Person, String> personStringFunction = person -> person.name;
//        //This Function takes a String and returns an Integer
//        ToIntFunction<String> length = String::length;
//        //This Function simply takes an Integer and prints out the result
//        IntConsumer println = System.out::println;

        /**
         * allMatch -> Predicate should have all match for the condition to be true
         * anyMatch -> Predicate should have any 1 match for the condition to be true
         * noneMatch -> Predicate should have no match for the condition to be true
         */
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
                .allMatch(personPredicate);
        System.out.println("Contains only females ? : " + containsOnlyFemales);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);



        people.stream()
                .forEach(person ->
                        System.out.println("Name is " + person.name + " Length of name is " + person.name.length()));
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
        MALE, FEMALE, PREFER_NOT_TO_SAY;
    }
}
