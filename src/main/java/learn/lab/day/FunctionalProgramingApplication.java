package learn.lab.day;

import learn.lab.day.useCase.UseDataSets;
import learn.lab.day.useCase.UseInterfaces;

public class FunctionalProgramingApplication {

    public static void main(String... args) {
        UseDataSets.workingWithDataSets();
        UseInterfaces.java8NewFunctions();
        //UseDataSets.compareFunctionalProgramingVsNormal(1_000_000);
    }

    private void bibliography(){
        String comparison = "https://jaxenter.com/java-performance-tutorial-how-fast-are-the-java-8-streams-118830.html";
        String examples = "https://hackernoon.com/finally-functional-programming-in-java-ad4d388fb92e";
        String rules = "http://tutorials.jenkov.com/java-functional-programming/index.html";
    }

}
