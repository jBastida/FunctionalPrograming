package learn.lab.day.useCase;

import learn.lab.day.interfaces.functional.DogAge;
import learn.lab.day.interfaces.functional.DogName;
import learn.lab.day.pojos.Dog;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseDataSets {

    public static void workingWithDataSets() {
        List<Dog> dogs = generateDogList(10);
        DogAge badPraxis = new DogAge() {
            @Override
            public Integer apply(Dog dog) {
                return dog.getAge();
            }
        };

        //getAges(dogs, dog -> dog.getAge());//if you only use one time this lambda

        DogAge goodPraxis = dog -> dog.getAge();
        getAges(dogs, goodPraxis);//if you use more than one time this lambda
        List<String> dogName = getNames(dogs, dog -> dog.getName());
    }

    public static List<Dog> generateDogList(Integer size) {
        List<Dog> dogs = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            dogs.add(generateDog(i));
        }

        return dogs;
    }

    private static Dog generateDog(Integer age) {
        final String name = MessageFormat.format("Dog{0}", age);
        return Dog.builder()
                .name(name)
                .age(age)
                .build();
    }

    private static List<Integer> getAges(List<Dog> dogs, DogAge f) {
        return dogs
                .stream()
                .map(f::apply)
                .collect(Collectors.toList());
    }

    private static List<String> getNames(List<Dog> dogs, DogName f) {
        return dogs
                .stream()
                .map(f::apply)
                .collect(Collectors.toList());
    }

    public static void compareFunctionalProgramingVsNormal(Integer size) {
        System.out.println(MessageFormat.format("Starting creating list of {0} elements", size));
        List<Dog> dogs = generateDogList(size);
        System.out.println(MessageFormat.format("List of {0} elements created", size));

        double ini = getSeconds();
        List<String> dogName = dogs
                                .parallelStream()
                                .filter(UseDataSets::isEvenDog)
                                .map(UseDataSets::getDogName)
                                .collect(Collectors.toList());
        printResult(ini, getSeconds(), "Time functional");

        ini = getSeconds();
        List<String> dogName2 = new ArrayList<>();
        for (Dog dog : dogs) {
            if(isEvenDog(dog)){
                dogName2.add(getDogName(dog));
            }
        }
        printResult(ini, getSeconds(), "Time normal");
    }

    private static boolean isEvenDog(Dog dog){
        return dog.getAge() % 2 == 0;
    }

    private static String getDogName(Dog dog){
        return dog.getName();
    }

    private static double getSeconds() {
        return Instant.now().getNano() / 1_000_000.0;
    }

    private static void printResult(double ini, double end, String type) {
        System.out.println(MessageFormat.format("{0} version: {1} seconds", type, end - ini));
    }

}
