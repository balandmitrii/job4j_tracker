package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        List<String> splitLeft = Arrays.asList(left.split("\\."));
        List<String> splitRight = Arrays.asList(right.split("\\."));
        int compareNumberPart = Integer.compare(
                Integer.parseInt(splitLeft.get(0)),
                Integer.parseInt(splitRight.get(0))
        );
        return compareNumberPart == 0
                ? left.compareTo(right)
                : compareNumberPart;
    }
}
