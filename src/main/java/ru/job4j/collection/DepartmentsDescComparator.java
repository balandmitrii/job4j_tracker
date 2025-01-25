package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] partsLeft = left.split("/");
        String[] partsRight = right.split("/");

        int minLength = Math.min(partsLeft.length, partsRight.length);

        for (int i = 0; i < minLength; i++) {
            int cmp;
            if (i == 0) {
                cmp = partsRight[i].compareTo(partsLeft[i]);
            } else {
                cmp = partsLeft[i].compareTo(partsRight[i]);
            }
            if (cmp != 0) {
                return cmp;
            }
        }

        return Integer.compare(
                left.split("/").length,
                right.split("/").length
        );
    }
}
