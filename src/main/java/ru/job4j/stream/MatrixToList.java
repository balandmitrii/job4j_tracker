package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {

    public static List<Integer> convert(Integer[][] matrix) {
        Function<Integer[], Stream<Integer>> function =
                (Integer[] items) -> Arrays.stream(items);
        return Arrays.stream(matrix)
                .flatMap(function)
                .collect(Collectors.toList());
    }
}