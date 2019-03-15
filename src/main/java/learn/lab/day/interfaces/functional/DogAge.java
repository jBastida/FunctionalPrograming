package learn.lab.day.interfaces.functional;

import learn.lab.day.pojos.Dog;

@FunctionalInterface
public interface DogAge {
    Integer apply(Dog dog);
}
