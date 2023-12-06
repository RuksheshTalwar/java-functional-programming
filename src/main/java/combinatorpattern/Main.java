package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        //if valid we can store the customer in db
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0525616718",
                LocalDate.of(2015, 1, 1));
//        System.out.println(new CustomerValidatorService().isValid(customer));

        /**
         * Using combinator design pattern
         * This is lazy invoking meaning that till I call apply() method, no other method calls are made,
         * for example of isPhoneNumberValid, isEmailValid, isAnAdult
         * As soon as I call apply() method
         */


        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
