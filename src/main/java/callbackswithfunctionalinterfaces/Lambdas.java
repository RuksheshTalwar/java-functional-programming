package callbackswithfunctionalinterfaces;

import java.util.function.BiFunction;

public class Lambdas {
    public static void main(String[] args) {
        BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
          if (name.isBlank()) throw new IllegalArgumentException("blank/incorrect name provided");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseName.apply("rukshesh", 35));
    }
}
