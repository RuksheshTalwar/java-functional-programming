package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        //Normal Java Function
        Customer mariaCustomer = new Customer("Maria", "989836563563");
        greetCustomer(mariaCustomer);
        greetCustomerV2(mariaCustomer, true);

        //Consumer Functional Interface
        greetCustomerConsumer.accept(mariaCustomer);

        //BiConsumer Functional Interface
        greetCustomerConsumerV2.accept(mariaCustomer, true);
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number " + customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number " + (showPhoneNumber ? customer.customerPhoneNumber : "***********"));

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " + customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, boolean showCustomerPhoneNo) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " + (showCustomerPhoneNo ? customer.customerPhoneNumber: "************"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer (String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
