package learn.lab.day.interfaces.functional;

import learn.lab.day.pojos.Dog;

@FunctionalInterface
public interface DogName {
    String apply(Dog dog);
}
