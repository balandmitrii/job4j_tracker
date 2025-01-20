package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split("\\.");
        String[] splitRight = right.split("\\.");
        int compareNumberPart = Integer.compare(
                Integer.parseInt(splitLeft[0]),
                Integer.parseInt(splitRight[0])
        );
        return compareNumberPart == 0
                ? left.compareTo(right)
                : compareNumberPart;
    }
}
