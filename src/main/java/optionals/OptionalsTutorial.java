package optionals;

import java.util.Optional;

public class OptionalsTutorial {
    public static void main(String[] args) {
        Optional<Cat> optionalCat = findCatByName("John");
        /**
         * get() method will throw NoSuchElementException if null object is returned by findCatByName(String name)
         * To prevent get() method to throw NoSuchElementException, we can use combination of isPresent() and get() methods as below
         */
//        if (optionalCat.isPresent()) {
//            System.out.println(optionalCat.get().getAge());
//        } else {
//            System.out.println(0);
//        }

        //using orElse we can get the actual object but if the object is null, new Cat Object is created and no Exception gets thrown
        Cat myCat = optionalCat.orElse(new Cat("UNKNOWN", 0));


        optionalCat.map(Cat:: getAge)
                .orElse(0);
    }

    /**
     * Optional are mainly intended to be used as a return type so that the user of this method knows that this method could return null
     * @param name
     * @return Optional<Cat>
     */
    private static Optional<Cat> findCatByName(String name) {
        Cat cat = new Cat(name, 3);
        //of method in Optional returns only the non-null value/object. So, only non-null values have to be passed to this method
        //Optional.of(cat);

        //If this cat object is null, it will create an empty Optional. If non-null, Optional returns that object or value
        return Optional.ofNullable(cat);
    }
}
