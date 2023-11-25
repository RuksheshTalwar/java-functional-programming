package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000045d"));
        System.out.println(isPhoneNumberValid("0900da00"));

        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000045d"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000045d"));

        System.out.println(
                "Is phone number valid and contains number 3 = "
         + isPhoneNumberValidPredicate.and(phoneNumberContains3Predicate).test("07000000003"));

        System.out.println(
                "Is phone number valid and contains number 3 = "
                        + isPhoneNumberValidPredicate.and(phoneNumberContains3Predicate).test("07000000003767"));

        System.out.println(
                "Is phone number valid and contains number 3 = "
                        + isPhoneNumberValidPredicate.or(phoneNumberContains3Predicate).test("07000000003767"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("0") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("0") && phoneNumber.length() == 11;

    static Predicate<String> phoneNumberContains3Predicate = phoneNumber ->
            phoneNumber.contains("3");
}
