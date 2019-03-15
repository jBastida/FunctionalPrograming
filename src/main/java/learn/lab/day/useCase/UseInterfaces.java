package learn.lab.day.useCase;

import learn.lab.day.interfaces.functional.SumTwo;
import learn.lab.day.pojos.Dog;

import java.text.MessageFormat;
import java.util.List;
import java.util.function.*;

public final class UseInterfaces {

    public static void java8NewFunctions() {
        List<Dog> dogs = UseDataSets.generateDogList(10);
        exampleOfCustomFunction();
        exampleOfBiFunction();
        exampleOfConsumer(dogs);
        exampleOfPredicate(dogs);
        exampleOfSupplier();
        exampleOfFunction();
    }

    private static void exampleOfCustomFunction() {
        SumTwo sum = customSum();
        Integer resultSum = sum.apply(4, 5);
        System.out.println(MessageFormat.format("Result of the sum is: {0}", resultSum));
    }

    //Custom Option
    private static SumTwo customSum() {
        return (a, b) -> a + b;
    }

    private static void exampleOfBiFunction() {
        BiFunction<Integer, Integer, Integer> javaSum = sum();
        Integer sumResult = javaSum.apply(5, 10);
        System.out.println(MessageFormat.format("Result of the sum is: {0}", sumResult));
        // or
        BiFunction<Integer, Integer, Integer> javaSubs = (i1, i2) -> i1 - i2;
        Integer subResult = javaSum.apply(5, 10);
        System.out.println(MessageFormat.format("Result of the subtraction is: {0}", subResult));
    }

    private static BiFunction<Integer, Integer, Integer> sum() {
        return (a, b) -> a + b;//a -> First, b-> Second, Result->Third
    }

    private static void exampleOfConsumer(List<Dog> dogs) {
        Consumer<Dog> printDog = dog -> System.out.println(MessageFormat.format("\t-{0}", dog.getName()));
        System.out.println("The names of the dogs are: ");
        dogs.forEach(printDog::accept);
    }

    private static void exampleOfPredicate(List<Dog> dogs) {
        Predicate<Dog> isEvenDog = dog -> dog.getAge() % 2 == 0;
        dogs
            .stream()
            .filter(isEvenDog)
            .forEach(dog -> System.out.println(MessageFormat.format("The dog {0} has even age", dog.getName())));
    }

    private static void exampleOfSupplier() {
        Supplier<Dog> createDog = () -> Dog.builder().name("").age(0).build();
        Dog dog = createDog.get();
        System.out.println(MessageFormat.format("The new dog is {0}", dog));
    }

    private static void exampleOfFunction() {
        Function<String, Dog> createNamedDog = name -> Dog.builder().name(name).build();
        Dog dog = createNamedDog.apply("Poky");
        System.out.println(MessageFormat.format("The new named dog is: {0}", dog));
    }

}
