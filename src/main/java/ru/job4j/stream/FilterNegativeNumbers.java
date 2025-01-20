package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, -3, -5, 0, 12, -9, 8);
        List<Integer> positiveNumbers = numbers
                .stream()
                .filter(n -> n > 0)
                .collect(Collectors.toList());
        positiveNumbers.forEach(System.out::println);
    }
}