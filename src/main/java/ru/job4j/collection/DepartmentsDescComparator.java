package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] partsLeft = left.split("/");
        String[] partsRight = right.split("/");
        int compareFirstParts = partsRight[0].compareTo(partsLeft[0]);

        if (compareFirstParts != 0) {
            return compareFirstParts;
        }

        return left.compareTo(right);
    }
}
