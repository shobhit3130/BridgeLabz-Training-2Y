package lambda;

import java.util.*;
import java.util.stream.Collectors;

public class UpperCaseName {
    public static void main(String[] args) {
        List<String> employeeNames = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Ethan");

        List<String> uppercased = employeeNames.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Uppercased Employee Names:");
        uppercased.forEach(System.out::println);
    }
}